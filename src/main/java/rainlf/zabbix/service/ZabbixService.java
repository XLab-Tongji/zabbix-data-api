package rainlf.zabbix.service;

import rainlf.zabbix.demo.ItemDO;
import rainlf.zabbix.demo.ItemHistoryDataDO;

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

    /**
     * 获取某主机的某监控项ID
     * @param hostId
     * @param itemDescription
     * @return
     */
    String getHostItemId(String hostId, String itemDescription);

    /**
     * 获取某监控项的指定时间段内的历史数据
     * @param itemId
     * @param itemDescription
     * @param timeFrom
     * @param timeTill
     * @return
     */
    ItemHistoryDataDO getItemHistoryData(String itemId, String itemDescription, Long timeFrom, Long timeTill);

    /**
     * 获取主机的所有监控项key
     * @param hostId
     * @return
     */
    List<ItemDO> getHostItem(String hostId);
}
