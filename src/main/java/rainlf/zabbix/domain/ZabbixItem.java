package rainlf.zabbix.domain;

public class ZabbixItem {

    private String itemId;
    private String valueType;
    private String key;

    public ZabbixItem() {
    }

    public String getItemId() {

        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ZabbixItem{" +
                "itemId='" + itemId + '\'' +
                ", valueType='" + valueType + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
