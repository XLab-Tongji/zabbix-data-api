package rainlf.zabbix.service;

import org.apache.poi.ss.usermodel.Workbook;
import rainlf.zabbix.domain.ZabbixHost;
import rainlf.zabbix.domain.ZabbixItem;
import rainlf.zabbix.domain.ZabbixItemData;

import java.util.List;

public interface ZabbixService {

    /**
     * 获取zabbix授权码
     * @return
     */
    String getZabbixAuth();

    /**
     * 获取zabbix监控主机列表
     * @return
     */
    List<ZabbixHost> getZabbixHosts();

    /**
     * 根据监控项key，获取zabbix监控项Id和ValueType
     * @param hostId
     * @param key
     * @return
     */
    ZabbixItem getZabbixItem(String hostId, String key);

    /**
     * 根据指定的hostId, 获取zabbix监控项列表
     * @param hostId
     * @return
     */
    List<ZabbixItem> getZabbixItemList(String hostId);

    /**
     * 获取zabbix监控项的历史数据
     * @param itemId
     * @param valueType
     * @return
     */
    List<ZabbixItemData> getZabbixItemHistoryData(String itemId, String valueType, String timeFrom, String timeTill);

    /**
     * 获取zabbix主机监控数据集
     * @param hostId
     * @param timeFrom
     * @param timeTill
     * @return
     */
    List<List<ZabbixItemData>> getZabbixHostDataSet(String hostId, String timeFrom, String timeTill);

    /**
     * 导出zabbix主机监控数据集
     * @param hostId
     * @param timeFrom
     * @param timeTill
     */
    void exportZabbixHostDataSet(String hostId, String timeFrom, String timeTill);

    /**
     * 生成Host Dataset文件
     */
    Workbook ZabbixHostDataSet(String hostId, String timeFrom, String timeTill);
}
