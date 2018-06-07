package rainlf.zabbix.controller;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import rainlf.zabbix.configuration.WebSecurityConfig;
import rainlf.zabbix.domain.ZabbixHost;
import rainlf.zabbix.domain.ZabbixItem;
import rainlf.zabbix.domain.ZabbixHost_details;
import rainlf.zabbix.domain.Zabbix_group;
import rainlf.zabbix.domain.Zabbix_template;
import rainlf.zabbix.domain.ZabbixItemData_clock;
import rainlf.zabbix.service.ZabbixService;

import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import rainlf.zabbix.utils.JWTTokenUtils;
import rainlf.zabbix.dao.UserDao;

@CrossOrigin
@RestController
public class ZabbixController {

    @Autowired
    private ZabbixService zabbixService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;


    @Autowired
    private UserDao userDao;

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
                                                      @RequestParam("port") String port,@RequestParam("hostid") String hostid,@RequestParam("key") String key, @RequestParam("time_from") String timeFrom,
                                                      @RequestParam("time_till") String timeTill){
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
    public JSONArray get_cluster() throws SQLException {
        return zabbixService.get_cluster();
    }

    @ApiOperation(value="监控项")
    @RequestMapping(value="get_item",method =RequestMethod.GET)
    public ZabbixItem get_item(@RequestParam("id") String id,
                               @RequestParam("key") String key){
        return zabbixService.getZabbixItem(id,key);
    }

    @ApiOperation(value="注册")
    @RequestMapping(value="register",method=RequestMethod.GET)
    public void register(@RequestParam("username") String username,
                         @RequestParam("password") String password) throws SQLException {
        zabbixService.register(username,password);
    }

    @ApiOperation(value="登录")
    @RequestMapping(value="Login",method=RequestMethod.POST)
    public String login(HttpServletResponse httpResponse,@RequestParam("username") String username,
                        @RequestParam("password") String password) throws Exception{
        //通过用户名和密码创建一个 Authentication 认证对象，实现类为 UsernamePasswordAuthenticationToken
        /*UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        //如果认证对象不为空
        if (Objects.nonNull(authenticationToken)){
            if(userDao.findByName(authenticationToken.getPrincipal().toString())==null){
                throw new Exception("用户不存在");
            }

        }
        try {
            //通过 AuthenticationManager（默认实现为ProviderManager）的authenticate方法验证 Authentication 对象
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            //将 Authentication 绑定到 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //生成Token
            String token = jwtTokenUtils.createToken(authentication,false);
            //将Token写入到Http头部
            httpResponse.addHeader(WebSecurityConfig.AUTHORIZATION_HEADER,"Bearer "+token);
            return "Bearer "+token;
        }catch (BadCredentialsException authentication){
            throw new Exception("密码错误");
        }*/
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        String password_validation=userDao.findByName(authenticationToken.getPrincipal().toString()).getPassword();
        if (Objects.nonNull(authenticationToken)){
             if(userDao.findByName(authenticationToken.getPrincipal().toString())==null){
                throw new Exception("用户不存在");
             }
             /*else if(password!=password_validation){
                throw new Exception("密码错误");
             }*/
        }
        //Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //if(authentication==null){
        //    return "yes";
        //}
        String token = jwtTokenUtils.createToken(username);
        httpResponse.addHeader(WebSecurityConfig.AUTHORIZATION_HEADER,"Bearer "+token);
        return "Bearer "+token;
    }

    @ApiOperation(value = "test")
    @RequestMapping(value="test",method=RequestMethod.GET)
    public int test(@RequestParam("username") String username,
                    @RequestParam("password") String password){
        if (userDao.findByName(username)!=null){
            return 1;
        }
        else {
            return 0;
        }
    }
}
