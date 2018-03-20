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
    List<Map<String, String>> getHostDataSet(String hostId, Integer timeFrom, Integer timeTill);
}
