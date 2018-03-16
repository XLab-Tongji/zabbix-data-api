package rainlf.zabbix.demo;

import java.util.List;

public class ItemHistoryDataDO {

    private String itemId;
    private List<ItemHistoryData> itemHistoryDataList;

    public ItemHistoryDataDO() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
                "itemId='" + itemId + '\'' +
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
