package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rainlf.zabbix.demo.ItemHistoryDataDO;
import rainlf.zabbix.service.ZabbixService;

import java.util.List;

@RestController
public class ZabbixController {

    @Autowired
    private ZabbixService zabbixService;

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

    @ApiOperation(value = "获取zabbix某个监控主机的某个监控项ID")
    @RequestMapping(value = "itemId", method = RequestMethod.GET)
    public String getHostItemId(@RequestParam("hostId") String hostId, @RequestParam("itemDescription") String itemDescription) {
        return zabbixService.getHostItemId(hostId, itemDescription);
    }

    @ApiOperation(value = "获取zabbix某监控项的指定时间段内的历史数据")
    @RequestMapping(value = "historyData", method = RequestMethod.GET)
    public ItemHistoryDataDO getItemHistoryData(@RequestParam("itemId") String itemId, @RequestParam("itemDescription") String itemDescription, @RequestParam("timeFrom") Long timeFrom, @RequestParam("timeTill") Long timeTill) {
        return zabbixService.getItemHistoryData(itemId, itemDescription, timeFrom, timeTill);
    }
}
