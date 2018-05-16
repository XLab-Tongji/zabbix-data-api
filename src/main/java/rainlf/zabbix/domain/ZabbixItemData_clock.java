package rainlf.zabbix.domain;

public class ZabbixItemData_clock {

    private String clock;
    private String value;

    public ZabbixItemData_clock() {
    }


    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ZabbixItemData{" +
                ", clock='" + clock + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
