class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, this.arr.size());
        this.arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        this.arr.set(idx, this.arr.get(this.arr.size() - 1));
        map.put(this.arr.get(idx), idx);
        this.arr.remove(this.arr.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return this.arr.get(rand.nextInt(this.arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */