package rainlf.zabbix.domain;

public class ZabbixHost {

    private String hostId;
    private String name;

    public ZabbixHost() {
    }

    public String getHostId() {

        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ZabbixHost{" +
                "hostId='" + hostId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
