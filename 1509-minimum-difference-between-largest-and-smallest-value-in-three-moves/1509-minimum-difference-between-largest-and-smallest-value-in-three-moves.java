class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n < 5) return 0;
        Arrays.sort(nums);
        int moves = 3;
        int minDiff = nums[n - 1] - nums[0];
        for(int i = 0; i <= moves; i++) {
            minDiff = Math.min(minDiff, nums[n - 1 - moves + i] - nums[i]);
        }
        return minDiff;
    }
}