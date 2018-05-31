package rainlf.zabbix.domain;

public class ZabbixHost_details {
    private String hostid;
    private String host;
    private String description;
    public ZabbixHost_details() {

    }

    public String getHostid() {

        return hostid;
    }

    public String getHost() {

        return host;
    }

    public String getDescription() {

        return description;
    }

    public void setHostId(String hostid) {
        this.hostid = hostid;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ZabbixHost{" +
                "hostid='" + hostid + '\'' +
                ", host='" + host + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
