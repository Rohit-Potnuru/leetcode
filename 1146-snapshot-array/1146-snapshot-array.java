class Pair {
    int value;
    int snap_id;
    Pair(int snap_id, int value) {
        this.snap_id = snap_id;
        this.value = value;
    }
}

class SnapshotArray {
    ArrayList<ArrayList<Pair>> snapArray;
    int totalSnap;
    public SnapshotArray(int length) {
        this.snapArray = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            ArrayList<Pair> list = new ArrayList<>();
            list.add(new Pair(-1, 0));
            this.snapArray.add(list);
        }
        this.totalSnap = 0;
    }
    
    public void set(int index, int val) {
        int n = this.snapArray.get(index).size();
        if(n == 1 || this.snapArray.get(index).get(n - 1).snap_id != this.totalSnap) {
            this.snapArray.get(index).add(new Pair(this.totalSnap, val));
        }
        n = this.snapArray.get(index).size();
        this.snapArray.get(index).get(n - 1).value = val;
    }
    
    public int snap() {
        this.totalSnap++;
        return this.totalSnap - 1;
    }
    
    public int get(int index, int snap_id) {
        int mid, start = 0, end = this.snapArray.get(index).size();
        while(start < end) {
            mid = (end - start)/2 + start;
            if(this.snapArray.get(index).get(mid).snap_id > snap_id) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return this.snapArray.get(index).get(start - 1).value;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */