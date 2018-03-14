package rainlf.zabbix.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
        JSONObject jsonObject = JSON.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"host.get\",\"params\":{\"output\":\"extend\"},\"auth\":\"" + auth + "\",\"id\":1}");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(zabbixUrl, jsonObject, String.class);
        String body = responseEntity.getBody();
        JSONArray resultList = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");

        List<String> hostList = new ArrayList<>();
        for (int i=0; i<resultList.size(); i++) {
           hostList.add(resultList.getJSONObject(i).getString("hostid"));
        }
        return hostList;
    }

}
