package rainlf.zabbix.demo;

public class ItemDataDO {

    private String timeStamp;
    private String value;

    public ItemDataDO() {
    }

    public String getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemDataDO{" +
                "timeStamp='" + timeStamp + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
