class Solution {
    public int rob(int[] nums) {
        int[] rob = new int[2];
        int maxRob = 0;
        for(int i = 0; i < nums.length; i++) {
            int t = nums[i];

            if(i > 1) {
                t = Math.max(t, nums[i] + nums[i - 2]);
            }
            if(i > 2) {
                t = Math.max(t, nums[i] + nums[i - 3]);
            }
            nums[i] = t;
            maxRob = Math.max(maxRob, nums[i]);
        }
        return maxRob;
    }
}