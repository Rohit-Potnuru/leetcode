class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxCount = 0;
        int totalElement = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int num: nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
            if(maxCount < hashmap.get(num)) {
                maxCount = hashmap.get(num);
                totalElement = 0;
            }
            if(maxCount == hashmap.get(num)) {
                totalElement += hashmap.get(num);
            }
        }
        return totalElement;
    }
}