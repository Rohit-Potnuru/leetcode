class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length, freq;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, -1) + 1);
            freq = freqMap.get(num);
            if(res.size() == freq) {
                res.add(new ArrayList<>());
            }
            res.get(freq).add(num);
        }
        return res;
    }
}