package rainlf.zabbix.service.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rainlf.zabbix.demo.ItemDO;
import rainlf.zabbix.demo.ItemDataDO;
import rainlf.zabbix.service.DataService;
import rainlf.zabbix.service.ZabbixService;
import rainlf.zabbix.util.DataUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private ZabbixService zabbixService;

    @Override
    public List<Map<String, String>> getHostDataSet(String hostId, Long timeFrom, Long timeTill) {

        // 获取主机所有的监控项目信息
        List<ItemDO> itemDOList = zabbixService.getHostItems(hostId);

        // 存放所有监控项目的历史数据信息
        Map<String, List<ItemDataDO>> historyDataMap = new HashMap<>();

        // 遍历监控项目
        for (ItemDO itemDO : itemDOList) {
            // 获取监控项历史数据
            List<ItemDataDO> itemDataDOList = zabbixService.getItemHistoryData(itemDO.getItemId(), Integer.parseInt(itemDO.getValueType()),  timeFrom, timeTill);

            // 插入数据
            historyDataMap.put(itemDO.getKey(), itemDataDOList);
        }

        // 遍历时间片
        List<Map<String, String>> timestampDataMapList = new ArrayList<>();
        for (long timestamp=timeFrom; timestamp<timeTill; timestamp+=5) {
            long timestamp2 = timestamp + 5;

            // 遍历historyDataMap
            Map<String, String> timestampDataMap = new HashMap<>();
            timestampDataMap.put("timestamp", String.valueOf(timestamp2));
            timestampDataMap.put("hostId", hostId);
            for (Map.Entry<String, List<ItemDataDO>> entry : historyDataMap.entrySet()) {
                // 取出时间片内数据
                boolean find = false;
                for (ItemDataDO itemDataDO : entry.getValue()) {
                    if (Integer.parseInt(itemDataDO.getTimeStamp()) > timestamp
                            && Integer.parseInt(itemDataDO.getTimeStamp()) <= timestamp2) {
                        find = true;
                        timestampDataMap.put(entry.getKey(), itemDataDO.getValue());
                    }
                }
                if (!find) {
                    timestampDataMap.put(entry.getKey(), "null");
                }
            }
            timestampDataMapList.add(timestampDataMap);
        }

        return timestampDataMapList;
    }

    @Override
    public String writeToFile(String hostId, List<Map<String, String>> timestampDataMapList) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");

        // 获取表头
        List<String> tableTitleList = new ArrayList<>();
        for (Map.Entry<String, String> entry : timestampDataMapList.get(0).entrySet()) {
            String key = entry.getKey();
            if (DataUtils.cleanKey(key)) {
                tableTitleList.add(key);
            }
        }

        // 重拍
        tableTitleList.remove("hostId");
        tableTitleList.remove("timestamp");
        tableTitleList.add(0, "hostId");
        tableTitleList.add(1, "timestamp");

        // 表头
        Row row = sheet.createRow(0);
        for (int i=0; i<tableTitleList.size(); i++) {
            row.createCell(i).setCellValue(tableTitleList.get(i));
        }

        // 内容
        int index = 0;
        for (Map<String, String> timestampDataMap : timestampDataMapList) {
            index ++;
            int cellIndex = 0;
            row = sheet.createRow(index);
            for (String key : tableTitleList) {
                String cellValue = timestampDataMap.get(key);
                row.createCell(cellIndex).setCellValue(cellValue);
                cellIndex ++;
            }
        }

        // 写入文件
        try {
            FileOutputStream out = new FileOutputStream("/tmp/" + hostId + ".csv");
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getHostDataSetCSV(String hostId, Long timeFrom, Long timeTill) {
        return this.writeToFile(hostId, this.getHostDataSet(hostId, timeFrom, timeTill));
    }
}
