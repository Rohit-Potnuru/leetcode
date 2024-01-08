class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int freq = 0, prev = nums[0] - 1;
        for(int num: nums) {
            if(prev != num) {
                freq = 0;
            }
            if(res.size() == freq) {
                res.add(new ArrayList<>());
            }
            res.get(freq++).add(num);
            prev = num;
        }
        return res;
    }
}