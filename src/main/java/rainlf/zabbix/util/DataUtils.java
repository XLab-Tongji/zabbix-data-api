package rainlf.zabbix.util;

public class DataUtils {

    /**
     * 过滤掉不需要的监控项
     * @param key
     * @return
     */
    public static Boolean cleanKey(String key) {
        if (("agent.ping".equals(key)) ||
                ("vfs.file.cksum[/etc/passwd]".equals(key)) ||
                ("system.boottime".equals(key)) ||
                ("system.localtime".equals(key)) ||
                ("system.hostname".equals(key)) ||
                ("agent.hostname".equals(key)) ||
                ("kernel.maxfiles".equals(key)) ||
                ("kernel.maxproc".equals(key)) ||
                ("system.users.num".equals(key)) ||
                ("system.uname".equals(key)) ||
                ("system.uptime".equals(key)) ||
                ("vm.memory.size[total]".equals(key)) ||
                ("system.swap.size[,total]".equals(key)) ||
                ("agent.version".equals(key))) {
            return false;
        }

        return true;
    }
}
