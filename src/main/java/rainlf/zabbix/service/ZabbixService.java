package rainlf.zabbix.service;

import rainlf.zabbix.demo.ItemDO;
import rainlf.zabbix.demo.ItemDataDO;

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
     * 获取某监控项的指定时间段内的历史数据
     * @param itemId
     * @param valueType
     * @param timeFrom
     * @param timeTill
     * @return
     */
    List<ItemDataDO> getItemHistoryData(String itemId, Integer valueType, Long timeFrom, Long timeTill);

    /**
     * 获取主机的所有监控项信息
     * @param hostId
     * @return
     */
    List<ItemDO> getHostItems(String hostId);

    /**
     * 获取某监控项信息
     * @param itemId
     * @return
     */
    ItemDO getItemInformation(String itemId);

    /**
     * 获取主机所有监控项的key
     * @param hostId
     * @return
     */
    List<String> getItemsKey(String hostId);

}
