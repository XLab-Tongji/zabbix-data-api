package rainlf.zabbix.service;

import org.apache.poi.ss.usermodel.Workbook;
import rainlf.zabbix.domain.*;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    /**
     * 根据指定ip,port的server获取该server下的所有主机
     */
    List<ZabbixHost_details> getZabbixHosts_dynamic(String ip,String port);

    /**
     * 输入ip,port,host,groupid(array),templateid,description创建新主机
     */
    void add_host(String ip, String port, String host,String hostip ,String groupid,String templateid,String description);

    /**
     * 删除主机
     */
    void delete_host(String ip,String port,String hostid);

    /**
     *获取模板及名字
     */
    List<Zabbix_template> getZabbix_template(String ip,String port);

    /**
     *获取主机组及名字
     */
    List<Zabbix_group> getZabbix_group(String ip, String port);

    /**
     *获取监控项数据
     */

    List<ZabbixItemData_clock> get_monitordata(String ip,String port,String key,String hostid,String timeFrom,String timeTill);

    /**
     * 添加集群
     */

    void add_cluster(String ip,String port,String name,String description,String username,String password) throws SQLException;

    /**
     * 删除集群
     */

    void delete_cluster(String ip,String port) throws SQLException;

    /**
     * 获取集群
     */

   List<String> get_cluster(String ip, String port) throws SQLException;

   String get_item(String id,String key);
}
