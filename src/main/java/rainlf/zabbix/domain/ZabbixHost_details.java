package rainlf.zabbix.domain;

public class ZabbixHost_details {
    private String hostId;
    private String host;
    private String description;
    public ZabbixHost_details() {

    }

    public String getHostId() {

        return hostId;
    }

    public String getHost() {

        return host;
    }

    public String getDescription() {

        return description;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
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
                "hostId='" + hostId + '\'' +
                ", host='" + host + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
