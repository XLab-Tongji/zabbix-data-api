package rainlf.zabbix.service;

import java.util.List;

public interface ZabbixService {

    /**
     * 获取zabbix服务器授权码
     * @return
     */
    String getZabbixAuth();

    /**
     * 获取zabbix被监控主机列表
     * @return
     */
    List<String> getZabbixHosts();
}
