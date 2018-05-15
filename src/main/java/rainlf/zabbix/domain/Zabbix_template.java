package rainlf.zabbix.domain;

public class Zabbix_template {
    private String templateid;
    private String host;
    public Zabbix_template() {

    }

    public String getHost() {

        return host;
    }

    public String getTemplateid() {

        return templateid;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    @Override
    public String toString() {
        return "Zabbixtemplate{" +
                ", host='" + host + '\'' +
                ", templateid='" + templateid + '\'' +
                '}';
    }
}
