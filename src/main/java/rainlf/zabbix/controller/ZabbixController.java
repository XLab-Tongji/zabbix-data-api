package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
