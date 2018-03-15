package rainlf.zabbix.demo;

import java.util.List;

public class ItemHistoryDataDO {

    private String name;
    private List<ItemHistoryData> itemHistoryDataList;

    public ItemHistoryDataDO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemHistoryData> getItemHistoryDataList() {
        return itemHistoryDataList;
    }

    public void setItemHistoryDataList(List<ItemHistoryData> itemHistoryDataList) {
        this.itemHistoryDataList = itemHistoryDataList;
    }

    @Override
    public String toString() {
        return "ItemHistoryDataDO{" +
                "name='" + name + '\'' +
                ", itemHistoryDataList=" + itemHistoryDataList.toString() +
                '}';
    }

    public class ItemHistoryData {
        private String timeStamp;
        private String value;

        public ItemHistoryData() {
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
            return "ItemHistoryData{" +
                    "timeStamp=" + timeStamp +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
