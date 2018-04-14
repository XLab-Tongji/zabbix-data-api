package rainlf.zabbix.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rainlf.zabbix.domain.ZabbixHost;
import rainlf.zabbix.domain.ZabbixItem;
import rainlf.zabbix.domain.ZabbixItemData;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZabbixServiceImplTest {

    @Autowired ZabbixService zabbixService;

    @Test
    public void getZabbixAuthTest() throws Exception {
        String auth = zabbixService.getZabbixAuth();
        System.out.println(auth);
    }

    @Test
    public void getZabbixHostsTest() throws Exception {
        List<ZabbixHost> zabbixHostList = zabbixService.getZabbixHosts();
        for (ZabbixHost zabbixHost : zabbixHostList) {
            System.out.println(zabbixHost.toString());
        }
    }

    @Test
    public void getZabbixItemTest() throws Exception {
        final String hostId = "10273";
        final String key = "system.swap.size[,pfree]";

        ZabbixItem zabbixItem = zabbixService.getZabbixItem(hostId, key);
        System.out.println(zabbixItem.toString());
    }

    @Test
    public void getZabbixItemListTest() throws Exception {
        final String hostId = "10273";

        List<ZabbixItem> zabbixItemList = zabbixService.getZabbixItemList(hostId);
        for (ZabbixItem zabbixItem : zabbixItemList) {
            System.out.println(zabbixItem.toString());
        }
    }

    @Test
    public void getZabbixItemHistoryDataTest() throws Exception {
        final String itemId = "30538";
        final String valueType = "0";
        final String timeFrom = "1523687205";
        final String timeTill = "1523687235";

        List<ZabbixItemData> zabbixItemDataList = zabbixService.getZabbixItemHistoryData(itemId, valueType, timeFrom, timeTill);
        for (ZabbixItemData zabbixItemData : zabbixItemDataList) {
            System.out.println(zabbixItemData.toString());
        }
    }

    @Test
    public void getZabbixHostDataSetTest() throws Exception {
        final String hostId = "10273";
        final String timeFrom = "1523687205";
        final String timeTill = "1523687235";

        List<List<ZabbixItemData>> zabbixHostData = zabbixService.getZabbixHostDataSet(hostId, timeFrom, timeTill);
        for (List<ZabbixItemData> zabbixItemDataList : zabbixHostData) {
            System.out.println(zabbixItemDataList.toString());
        }
    }

    @Test
    public void exportZabbixHostDataSetTest() throws Exception {
        final String hostId = "10273";
        final String timeFrom = "1523687205";
        final String timeTill = "1523687235";

        zabbixService.exportZabbixHostDataSet(hostId, timeFrom, timeTill);
    }
}