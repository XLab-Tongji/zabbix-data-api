package rainlf.zabbix.domain;

public class Zabbix_group {
    private String groupid;
    private String name;
    public Zabbix_group() {

    }

    public String getName() {

        return name;
    }

    public String getGroupid() {

        return groupid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    @Override
    public String toString() {
        return "Zabbixtemplate{" +
                ", name='" + name + '\'' +
                ", groupid='" + groupid + '\'' +
                '}';
    }
}