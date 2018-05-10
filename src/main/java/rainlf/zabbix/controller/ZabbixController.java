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
import rainlf.zabbix.service.ZabbixService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

}
