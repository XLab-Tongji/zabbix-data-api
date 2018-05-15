package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rainlf.zabbix.domain.ZabbixHost;
import rainlf.zabbix.domain.ZabbixHost_details;
import rainlf.zabbix.domain.Zabbix_template;
import rainlf.zabbix.service.ZabbixService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
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
    @RequestMapping(value = "hostData", method = RequestMethod.GET)
    public void getZabbixHostDataSet(@RequestParam("hostId") String hostId,
                                     @RequestParam("timeFrom") String timeFrom,
                                     @RequestParam("timeTill") String timeTill) {
        zabbixService.exportZabbixHostDataSet(hostId, timeFrom, timeTill);
    }

    @ApiOperation(value="下载生成的EXCEL文件")
    @RequestMapping(value="filedownload",method=RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,@RequestParam("hostId") String hostId,
                             @RequestParam("timeFrom") String timeFrom,
                             @RequestParam("timeTill") String timeTill)throws IOException{
        Workbook workbook=zabbixService.ZabbixHostDataSet(hostId, timeFrom, timeTill);
        String filename="Zabbix.xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=ZabbixHostDataSet.xls");//默认Excel名称
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @ApiOperation(value = "查找指定server下的所有主机")
    @RequestMapping(value = "get_host", method = RequestMethod.GET)
    public List<ZabbixHost_details> getZabbixHost_dynamic(@RequestParam("ip") String ip,
                                                  @RequestParam("port") String port) {
        return zabbixService.getZabbixHosts_dynamic(ip,port);
    }

    @ApiOperation(value = "添加主机")
    @RequestMapping(value = "add_host", method = RequestMethod.GET)
    public void add_host(@RequestParam("ip") String ip,
                                                          @RequestParam("port") String port,@RequestParam("host") String host,@RequestParam("groupid") String groupid,@RequestParam("template") String templateid,@RequestParam("description") String description) {
        zabbixService.add_host(ip,port,host,groupid,templateid,description);
    }

    @ApiOperation(value = "删除主机")
    @RequestMapping(value = "delete_host", method = RequestMethod.GET)
    public void delete(@RequestParam("ip") String ip,
                       @RequestParam("port") String port,@RequestParam("hostid") String hostid){
        zabbixService.delete_host(ip,port,hostid);
    }

    @ApiOperation(value = "查找指定server下的所有模板和名字")
    @RequestMapping(value = "get_template", method = RequestMethod.GET)
    public List<Zabbix_template> getZabbix_template(@RequestParam("ip") String ip,
                                                       @RequestParam("port") String port) {
        return zabbixService.getZabbix_template(ip,port);
    }

    @ApiOperation(value = "查找指定server下的所有模板和名字")
    @RequestMapping(value = "get_template", method = RequestMethod.GET)
    public List<Zabbix_template> getZabbix_group(@RequestParam("ip") String ip,
                                                    @RequestParam("port") String port) {
        return zabbixService.getZabbix_group(ip,port);
    }
}
