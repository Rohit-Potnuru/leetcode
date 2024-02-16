class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int i;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> freqCount = new ArrayList<>();
        for(int a: arr) {
            if(!freqMap.containsKey(a)) {
                freqMap.put(a, freqCount.size());
                freqCount.add(0);
            }
            i = freqMap.get(a);
            freqCount.set(i, freqCount.get(i) + 1);
        }
        Collections.sort(freqCount);

        i = freqMap.size();
        int j = 0;
        while(j < freqCount.size() && k > 0) {
            k -= freqCount.get(j++);
        }
        if(k != 0) j--;

        return i - j;
    }
}