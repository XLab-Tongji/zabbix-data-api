package rainlf.zabbix.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rainlf.zabbix.demo.ItemDO;
import rainlf.zabbix.demo.ItemHistoryDataDO;
import rainlf.zabbix.service.ZabbixService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZabbixServiceImpl implements ZabbixService{

    @Value("${zabbixUrl}")
    private String zabbixUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getZabbixAuth() {
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"user.login\",\"params\":{\"user\":\"Admin\",\"password\":\"zabbix\"},\"id\":1,\"auth\":null}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        String body = responseEntity.getBody();
        String auth = JSON.parseObject(body).getString("result");
        return auth;
    }

    @Override
    public List<String> getZabbixHosts() {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"host.get\",\"params\":{\"output\":\"extend\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<String> hostList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
           hostList.add(resultList.getJSONObject(i).getString("hostid"));
        }
        return hostList;
    }

    @Override
    public String getHostItemId(String hostId, String itemDescription) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"item.get\",\"params\":{\"output\":\"extend\",\"hostids\":\""
                + hostId + "\",\"search\":{\"key_\":\"" + itemDescription + "\"},\"sortfield\":\"name\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        return resultList.getJSONObject(0).getString("itemid");
    }

    @Override
    public ItemHistoryDataDO getItemHistoryData(String itemId, String itemDescription, Long timeFrom, Long timeTill) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"history.get\",\"params\":{\"output\":\"extend\",\"history\":0,\"itemids\":\""
                + itemId + "\",\"sortfield\":\"clock\",\"sortorder\":\"ASC\",\"time_from\":\""
                + timeFrom + "\",\"time_till\":\""
                + timeTill + "\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        ItemHistoryDataDO itemHistoryDataDO = new ItemHistoryDataDO();
        itemHistoryDataDO.setName(itemDescription);
        List<ItemHistoryDataDO.ItemHistoryData> itemHistoryDataList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            // doubt rain
            ItemHistoryDataDO.ItemHistoryData itemHistoryData = new ItemHistoryDataDO().new ItemHistoryData();
            itemHistoryData.setTimeStamp(resultList.getJSONObject(i).getString("clock"));
            itemHistoryData.setValue(resultList.getJSONObject(i).getString("value"));

            itemHistoryDataList.add(itemHistoryData);
        }
        itemHistoryDataDO.setItemHistoryDataList(itemHistoryDataList);

        return itemHistoryDataDO;
    }

    @Override
    public List<ItemDO> getHostItem(String hostId) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"item.get\",\"params\":{\"output\":\"extend\",\"hostids\":\""
                + hostId + "\",\"sortfield\":\"name\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<ItemDO> itemDOList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            ItemDO itemDO = new ItemDO();
            itemDO.setName(resultList.getJSONObject(i).getString("name"));
            itemDO.setValueType(resultList.getJSONObject(i).getString("value_type"));
            itemDO.setKey(resultList.getJSONObject(i).getString("key_"));
            itemDO.setDescription(resultList.getJSONObject(i).getString("description"));

            itemDOList.add(itemDO);
        }

        return itemDOList;
    }

}
