package rainlf.zabbix.demo;

public class ItemDO {

    private String name;
    private String valueType;
    private String key;
    private String description;

    public ItemDO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemDO{" +
                "name='" + name + '\'' +
                ", valueType='" + valueType + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
