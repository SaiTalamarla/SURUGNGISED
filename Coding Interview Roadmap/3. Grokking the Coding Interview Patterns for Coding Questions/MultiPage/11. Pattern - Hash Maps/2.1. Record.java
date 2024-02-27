public class Record {

    public int key;
    public String title;
    public String placementInfo;

    public Record() {
        Key = -1;
    }

    public Record(int key, String title, String placementInfo) {
        key = key;
        title = title;
        placementInfo = placementInfo;
    }
}