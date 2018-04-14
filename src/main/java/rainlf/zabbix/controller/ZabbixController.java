package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rainlf.zabbix.domain.ZabbixHost;
import rainlf.zabbix.service.ZabbixService;

import java.util.List;


@CrossOrigin
@RestController
public class ZabbixController {

    @Autowired
    private ZabbixService zabbixService;

    @ApiOperation(value = "获取zabbix主机信息")
    @RequestMapping(value = "hosts", method = RequestMethod.GET)
    public List<ZabbixHost> getZabbixAuth() {
        return zabbixService.getZabbixHosts();
    }

    @ApiOperation(value = "获取zabbix主机监控数据集")
    @RequestMapping(value = "hosts", method = RequestMethod.GET)
    public void getZabbixHostDataSet(@RequestParam("hostId") String hostId,
                                     @RequestParam("timeFrom") String timeFrom,
                                     @RequestParam("timeTill") String timeTill) {
        zabbixService.exportZabbixHostDataSet(hostId, timeFrom, timeTill);
    }

}
