class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num: nums2) {
            if(freqMap.getOrDefault(num, 0) > 0) {
                freqMap.put(num, freqMap.get(num) - 1);
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}