class ValueStamp {
    int timestamp;
    String value;
    public ValueStamp(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    HashMap<String, ArrayList<ValueStamp>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.timeMap.containsKey(key)) {
            this.timeMap.put(key, new ArrayList<>());
        }
        this.timeMap.get(key).add(new ValueStamp(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(this.timeMap.containsKey(key)) {
            int start = 0, end = this.timeMap.get(key).size(), mid;
            while(start < end) {
                mid = (end - start)/2 + start;
                int midTimestamp = this.timeMap.get(key).get(mid).timestamp;
                if(midTimestamp <= timestamp) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
            if(start != 0) 
                return this.timeMap.get(key).get(start - 1).value;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */