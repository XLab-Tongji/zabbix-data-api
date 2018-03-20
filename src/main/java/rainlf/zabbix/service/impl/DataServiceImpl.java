package rainlf.zabbix.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rainlf.zabbix.demo.ItemDO;
import rainlf.zabbix.demo.ItemDataDO;
import rainlf.zabbix.service.DataService;
import rainlf.zabbix.service.ZabbixService;

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

        // mock data time
//        int timeFrom = 10000;
//        int timeTill = 20000;

        // 遍历时间片
        List<Map<String, String>> timestampDataMapList = new ArrayList<>();
        for (long timestamp=timeFrom; timestamp<=timeTill; timestamp+=5) {
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
                    timestampDataMap.put(entry.getKey(), null);
                }
            }
            timestampDataMapList.add(timestampDataMap);
        }

        return timestampDataMapList;
    }

    @Override
    public void writeHostDataSetExcel(List<Map<String, String>> timestampDataMapList) {

    }
}
