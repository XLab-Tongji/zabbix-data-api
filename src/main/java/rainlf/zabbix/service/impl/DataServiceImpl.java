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
import java.util.*;

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

        // 重排
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
                // 跳过忽略key
                if (isBlackKey(key)) {
                    continue;
                }

                // 归整化时间戳
                String cellValue = timestampDataMap.get(key);
                if ("timestamp".equals(key)) {
                    int end = Integer.valueOf(cellValue.substring(cellValue.length()-1));
                    int tempTimestamp = 0;
                    if (end > 5) {
                        tempTimestamp = Integer.valueOf(cellValue) - end + 5;
                    } else {
                        tempTimestamp = Integer.valueOf(cellValue) - end;
                    }
                    row.createCell(cellIndex).setCellValue(String.valueOf(tempTimestamp));
                } else {
                    row.createCell(cellIndex).setCellValue(cellValue);
                }
                cellIndex ++;
            }
        }

        // 清洗数据
        workbook = cleanDataSet(workbook);

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

    /**
     * 清洗数据
     * @param workbook
     * @return
     */
    private static Workbook cleanDataSet(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);

        return workbook;
    }

    private static Boolean isBlackKey(String key) {
        List<String> blackList = Arrays.asList("veth51506c2", "vethr060ca4614c", "vethr3a98e4f043",
                "vethr3d0d1191a8", "vethr6e9a1a0292", "vethr7c099ce9d2", "vethr28dfd2b4b7", "vethr38faa2f76b",
                "vethr84dabbbc5c", "vethr943f5c4d3c", "vethr4974e4532e", "vethr6674dee1c1", "vethr6898b2944b",
                "vethr8483e9380f", "vethr35292c940d", "vethraeace4bac9", "vethrbd0e923e36", "vethre5d19bea07",
                "veth51506c2", "vethr060ca4614c", "vethr3a98e4f043", "vethr3d0d1191a8", "vethr6e9a1a0292",
                "vethr7c099ce9d2", "vethr28dfd2b4b7", "vethr38faa2f76b", "vethr84dabbbc5c", "vethr943f5c4d3c",
                "vethr4974e4532e", "vethr6674dee1c1", "vethr6898b2944b", "vethr8483e9380f", "vethr35292c940d",
                "vethraeace4bac9", "vethrbd0e923e36", "vethre5d19bea07");
        if (blackList.contains(key)) {
            return true;
        } else {
            return false;
        }
    }
}
