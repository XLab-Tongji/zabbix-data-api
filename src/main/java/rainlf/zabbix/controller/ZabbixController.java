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
import rainlf.zabbix.domain.ZabbixItem;
import rainlf.zabbix.domain.ZabbixHost_details;
import rainlf.zabbix.domain.Zabbix_group;
import rainlf.zabbix.domain.Zabbix_template;
import rainlf.zabbix.domain.ZabbixItemData_clock;
import rainlf.zabbix.service.ZabbixService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @ApiOperation(value = "下载生成的EXCEL文件")
    @RequestMapping(value = "filedownload",method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,
                             @RequestParam("hostId") String hostId,
                             @RequestParam("timeFrom") String timeFrom,
                             @RequestParam("timeTill") String timeTill) throws IOException {
        Workbook workbook = zabbixService.ZabbixHostDataSet(hostId, timeFrom, timeTill);
        String filename = "host" + hostId + ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        response.flushBuffer();
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
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
                                                          @RequestParam("port") String port,@RequestParam("host") String host,@RequestParam("hostip") String hostip,@RequestParam("groupid") String groupid,@RequestParam("template") String templateid,@RequestParam("description") String description) {
        zabbixService.add_host(ip,port,host,hostip,groupid,templateid,description);
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
    @RequestMapping(value = "get_group", method = RequestMethod.GET)
    public List<Zabbix_group> getZabbix_group(@RequestParam("ip") String ip,
                                              @RequestParam("port") String port) {
        return zabbixService.getZabbix_group(ip,port);
    }

    @ApiOperation(value="获取监控项数据")
    @RequestMapping(value="get_monitordata",method = RequestMethod.GET)
    public List<ZabbixItemData_clock> get_monitordata(@RequestParam("ip") String ip,
                                                      @RequestParam("port") String port,@RequestParam("hostid") String hostid,@RequestParam("key") String key, @RequestParam("timeFrom") String timeFrom,
                                                      @RequestParam("timeTill") String timeTill){
        return  zabbixService.get_monitordata(ip,port,hostid,key,timeFrom,timeTill);
    }

    @ApiOperation(value="添加集群")
    @RequestMapping(value="add_cluster",method=RequestMethod.GET)
    public void add_cluster(@RequestParam("ip") String ip,
                            @RequestParam("port") String port,@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("username") String username,@RequestParam("password") String password) throws SQLException {
        zabbixService.add_cluster(ip, port, name,description,username,password);
    }

    @ApiOperation(value = "删除集群")
    @RequestMapping(value="delete_cluster",method = RequestMethod.GET)
    public void delete_cluster(@RequestParam("ip") String ip,
                               @RequestParam("port") String port) throws SQLException {
        zabbixService.delete_cluster(ip,port);
    }

    @ApiOperation(value="获得集群")
    @RequestMapping(value="get_cluster",method=RequestMethod.GET)
    public List<String> get_cluster(@RequestParam("ip") String ip,
                                 @RequestParam("port") String port) throws SQLException {
        return zabbixService.get_cluster(ip,port);
    }

    @ApiOperation(value="监控项")
    @RequestMapping(value="get_item",method =RequestMethod.GET)
    public ZabbixItem get_item(@RequestParam("id") String id,
                @RequestParam("key") String key){
           return  zabbixService.getZabbixItem(id,key);
    }

}
