class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            if(!freq.containsKey(num)) {
                freq.put(num, 0);
            }
            freq.put(num, freq.get(num) + 1);
        }

        int count = 0;
        for(int num: freq.keySet()) {
            if(freq.get(num) == 1) {
                return -1;
            }
            count += freq.get(num)/3 + (freq.get(num) % 3 + 1)/2;
        }
        return count;
    }
}