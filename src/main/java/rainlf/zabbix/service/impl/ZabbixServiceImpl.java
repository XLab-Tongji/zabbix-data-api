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
import rainlf.zabbix.demo.ItemDataDO;
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
    public List<ItemDataDO> getItemHistoryData(String itemId, Integer valueType, Long timeFrom, Long timeTill) {
        String auth = getZabbixAuth();
        JSONObject jsonObject;
        if ((timeFrom == null) || (timeTill == null)) {
            jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"history.get\",\"params\":{\"output\":\"extend\",\"history\":"
                    + valueType + ",\"itemids\":\""
                    + itemId + "\",\"sortfield\":\"clock\",\"sortorder\":\"ASC\"},\"auth\":\""
                    + auth + "\",\"id\":1}");
        } else {
            jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"history.get\",\"params\":{\"output\":\"extend\",\"history\":"
                    + valueType + ",\"itemids\":\""
                    + itemId + "\",\"sortfield\":\"clock\",\"sortorder\":\"ASC\",\"time_from\":\""
                    + timeFrom + "\",\"time_till\":\""
                    + timeTill + "\"},\"auth\":\""
                    + auth + "\",\"id\":1}");
        }

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<ItemDataDO> itemDataList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            ItemDataDO itemDataDO = new ItemDataDO();
            itemDataDO.setTimeStamp(resultList.getJSONObject(i).getString("clock"));
            itemDataDO.setValue(resultList.getJSONObject(i).getString("value"));

            itemDataList.add(itemDataDO);
        }

        return itemDataList;
    }

    @Override
    public List<ItemDO> getHostItems(String hostId) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"item.get\",\"params\":{\"output\":\"extend\",\"hostids\":\""
                + hostId + "\",\"sortfield\":\"name\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<ItemDO> itemDOList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            ItemDO itemDO = new ItemDO();
            itemDO.setItemId(resultList.getJSONObject(i).getString("itemid"));
            itemDO.setName(resultList.getJSONObject(i).getString("name"));
            itemDO.setValueType(resultList.getJSONObject(i).getString("value_type"));
            itemDO.setKey(resultList.getJSONObject(i).getString("key_"));
            itemDO.setDescription(resultList.getJSONObject(i).getString("description"));

            itemDOList.add(itemDO);
        }

        return itemDOList;
    }

    @Override
    public ItemDO getItemInformation(String itemId) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"item.get\",\"params\":{\"output\":\"extend\",\"itemids\":\""
                + itemId + "\",\"sortfield\":\"name\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        ItemDO itemDO = new ItemDO();
        JSONObject itemJsonObj = resultList.getJSONObject(0);
        itemDO.setItemId(itemJsonObj.getString("itemid"));
        itemDO.setName(itemJsonObj.getString("name"));
        itemDO.setValueType(itemJsonObj.getString("value_type"));
        itemDO.setKey(itemJsonObj.getString("key_"));
        itemDO.setDescription(itemJsonObj.getString("description"));

        return itemDO;
    }

    @Override
    public List<String> getItemsKey(String hostId) {
        String auth = getZabbixAuth();
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"item.get\",\"params\":{\"output\":\"extend\",\"hostids\":\""
                + hostId + "\",\"sortfield\":\"name\"},\"auth\":\""
                + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<String> itemKeyList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
            itemKeyList.add(resultList.getJSONObject(i).getString("key_"));
        }

        return itemKeyList;
    }

}
