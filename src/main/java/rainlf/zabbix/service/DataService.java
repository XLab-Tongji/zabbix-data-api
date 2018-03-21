package rainlf.zabbix.service;

import java.util.List;
import java.util.Map;

public interface DataService {

    /**
     * 获取主机的监控数据集
     * @param hostId
     * @param timeFrom
     * @param timeTill
     * @return
     */
    List<Map<String, String>> getHostDataSet(String hostId, Long timeFrom, Long timeTill);

    /**
     * 主机的监控数据集写入
     * @param hostId
     * @param timestampDataMapList
     * @return
     */
    String writeToFile(String hostId, List<Map<String, String>> timestampDataMapList);

    /**
     * 获取主机的监控数据集文件
     * @param hostId
     * @param timeFrom
     * @param timeTill
     * @return
     */
    String getHostDataSetCSV(String hostId, Long timeFrom, Long timeTill);
}
