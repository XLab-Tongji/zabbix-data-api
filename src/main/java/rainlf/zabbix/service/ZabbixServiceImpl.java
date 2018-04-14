package rainlf.zabbix.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rainlf.zabbix.consts.ConfigConsts;
import rainlf.zabbix.domain.ZabbixHost;
import rainlf.zabbix.domain.ZabbixItem;
import rainlf.zabbix.domain.ZabbixItemData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rain
 */
@Service
public class ZabbixServiceImpl implements ZabbixService {

    @Value("${zabbix.url}")
    private String zabbixUrl;

    @Value("${file.path}")
    private String filePath;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getZabbixAuth() {
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"user.login\",\"params\":{\"user\":\"Admin\",\"password\":\"zabbix\"},\"id\":1,\"auth\":null}");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        String body = responseEntity.getBody();

        return JSON.parseObject(body).getString("result");
    }

    @Override
    public List<ZabbixHost> getZabbixHosts() {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"host.get\",\"params\":{\"output\":\"extend\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<ZabbixHost> zabbixHostList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            ZabbixHost zabbixHost = new ZabbixHost();
            zabbixHost.setName(resultList.getJSONObject(i).getString("host"));
            zabbixHost.setHostId(resultList.getJSONObject(i).getString("hostid"));
            zabbixHostList.add(zabbixHost);
        }
        return zabbixHostList;
    }

    @Override
    public ZabbixItem getZabbixItem(String hostId, String key) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"item.get\",\"params\":{\"output\":\"extend\",\"hostids\":\""
                + hostId + "\",\"search\":{\"key_\":\""
                + key + "\"},\"sortfield\":\"name\"},\"auth\":\""
                + auth + "\",\"id\":1}");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        String body = responseEntity.getBody();
        JSONObject result = JSON.parseObject(body).getJSONArray("result").getJSONObject(0);

        ZabbixItem zabbixItem = new ZabbixItem();
        zabbixItem.setItemId(result.getString("itemid"));
        zabbixItem.setValueType(result.getString("value_type"));
        zabbixItem.setKey(result.getString("key_"));

        return zabbixItem;
    }

    @Override
    public List<ZabbixItem> getZabbixItemList(String hostId) {
        /**
         * 硬编码监控项keyList
         */
        List<String> keyList = ConfigConsts.getZabbixItems();

        List<ZabbixItem> zabbixItemList = new ArrayList<>();
        for (String key : keyList) {
            ZabbixItem zabbixItem = getZabbixItem(hostId, key);
            zabbixItemList.add(zabbixItem);
        }

        return zabbixItemList;
    }

    @Override
    public List<ZabbixItemData> getZabbixItemHistoryData(String itemId, String valueType, String timeFrom, String timeTill) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"history.get\",\"params\":{\"output\":\"extend\",\"itemids\":\""
                + itemId + "\",\"history\":\""
                + valueType + "\",\"sortfield\":\"clock\",\"sortorder\":\"ASC\",\"time_from\":\""
                + timeFrom + ".\",\"time_till\":\""
                + timeTill + "\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        String body = responseEntity.getBody();
        JSONArray resultList = JSON.parseObject(body).getJSONArray("result");

        List<ZabbixItemData> zabbixItemDataList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            ZabbixItemData zabbixItemData = new ZabbixItemData();
            zabbixItemData.setItemId(resultList.getJSONObject(i).getString("itemid"));
            zabbixItemData.setClock(resultList.getJSONObject(i).getString("clock"));
            zabbixItemData.setValue(resultList.getJSONObject(i).getString("value"));

            zabbixItemDataList.add(zabbixItemData);
        }
        return zabbixItemDataList;
    }

    @Override
    public List<List<ZabbixItemData>> getZabbixHostDataSet(String hostId, String timeFrom, String timeTill) {
        List<ZabbixItem> zabbixItemList = getZabbixItemList(hostId);

        List<List<ZabbixItemData>> zabbixHostData = new ArrayList<>();
        for (ZabbixItem zabbixItem : zabbixItemList) {
            List<ZabbixItemData> zabbixItemDataList = getZabbixItemHistoryData(zabbixItem.getItemId(),
                    zabbixItem.getValueType(), timeFrom, timeTill);
            zabbixHostData.add(zabbixItemDataList);
        }

        return zabbixHostData;
    }

    @Override
    public void exportZabbixHostDataSet(String hostId, String timeFrom, String timeTill) {
        List<ZabbixItem> zabbixItemList = getZabbixItemList(hostId);
        List<List<ZabbixItemData>> zabbixHostData = getZabbixHostDataSet(hostId, timeFrom, timeTill);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("data");

        // 首行
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("host");
        row.createCell(1).setCellValue("clock");

        // 首行
        int index = 2;
        for (ZabbixItem zabbixItem : zabbixItemList) {
            row.createCell(index).setCellValue(zabbixItem.getKey());
            index++;
        }

        // 按列写数据
        int rowIndex = 1;
        int cellIndex = 2;
        for (List<ZabbixItemData> zabbixItemDataList : zabbixHostData) {
            for (ZabbixItemData zabbixItemData : zabbixItemDataList) {
                row = sheet.getRow(rowIndex);
                if (null == row) {
                    row = sheet.createRow(rowIndex);
                }
                row.createCell(cellIndex).setCellValue(zabbixItemData.getValue());
                rowIndex++;
            }
            cellIndex++;
            rowIndex = 1;
        }

        // 首、次列
        String startTime = zabbixHostData.get(0).get(0).getClock();
        int end = Integer.valueOf(startTime.substring(startTime.length()-1));
        if (end < 5) {
            String startTimeRe = String.valueOf(Integer.valueOf(startTime) - end);
        } else {
            String startTimeRe = String.valueOf(Integer.valueOf(startTime) - end + 5);
        }
        for (int i=1; i<=sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            row.createCell(0).setCellValue(hostId);
            row.createCell(1).setCellValue(startTime);
            startTime = String.valueOf(Integer.valueOf(startTime) + 5);
        }

        try {
            FileOutputStream out = new FileOutputStream(String.format(filePath, hostId));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}