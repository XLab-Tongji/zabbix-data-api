package rainlf.zabbix.domain;

public class ZabbixItemData {

    private String itemId;
    private String clock;
    private String value;

    public ZabbixItemData() {
    }

    public String getItemId() {

        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
                "itemId='" + itemId + '\'' +
                ", clock='" + clock + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
