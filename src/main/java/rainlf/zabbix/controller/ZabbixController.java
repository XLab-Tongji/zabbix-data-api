package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rainlf.zabbix.demo.ItemDO;
import rainlf.zabbix.demo.ItemDataDO;
import rainlf.zabbix.service.DataService;
import rainlf.zabbix.service.ZabbixService;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ZabbixController {

    @Autowired
    private ZabbixService zabbixService;

    @Autowired
    private DataService dataService;

    @ApiOperation(value = "获取zabbix授权码")
    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String getZabbixAuth() {
        return zabbixService.getZabbixAuth();
    }

    @ApiOperation(value = "获取zabbix监控主机")
    @RequestMapping(value = "hosts", method = RequestMethod.GET)
    public List<String> getZabbixHosts() {
        return zabbixService.getZabbixHosts();
    }

    @ApiOperation(value = "获取zabbix某监控项的指定时间段内的历史数据")
    @RequestMapping(value = "itemData", method = RequestMethod.GET)
    public List<ItemDataDO> getItemHistoryData(@RequestParam("itemId") String itemId,
                                         @RequestParam("valueType") Integer valueType,
                                         @RequestParam(value = "timeFrom", required = false) Long timeFrom,
                                         @RequestParam(value = "timeTill", required = false) Long timeTill) {
        return zabbixService.getItemHistoryData(itemId, valueType, timeFrom, timeTill);
    }

    @ApiOperation(value = "获取zabbix某主机的所有监控项信息")
    @RequestMapping(value = "items", method = RequestMethod.GET)
    public List<ItemDO> getHostItem(@RequestParam("hostId") String hostId) {
        return zabbixService.getHostItems(hostId);
    }

    @ApiOperation(value = "获取zabbix某监控项的信息")
    @RequestMapping(value = "item", method = RequestMethod.GET)
    public ItemDO getItemInformation(@RequestParam("itemId") String itemId) {
        return zabbixService.getItemInformation(itemId);
    }

    @ApiOperation(value = "获取zabbix某主机的所有监控项key")
    @RequestMapping(value = "itemsKey", method = RequestMethod.GET)
    public List<String> getItemsKey(@RequestParam("hostId") String hostId) {
        return zabbixService.getItemsKey(hostId);
    }

    @ApiOperation(value = "获取主机的监控数据集")
    @RequestMapping(value = "hostDataSet", method = RequestMethod.GET)
    public List<Map<String, String>> getHostDataSet(@RequestParam("hostId") String hostId,
                                                    @RequestParam("timeFrom") Long timeFrom,
                                                    @RequestParam("timeTill") Long timeTill) {
        return dataService.getHostDataSet(hostId, timeFrom, timeTill);
    }
}
