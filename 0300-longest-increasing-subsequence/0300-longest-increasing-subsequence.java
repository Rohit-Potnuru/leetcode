class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];

        int max = 0, longest = 1;
        for(int i = 0; i < n; i++) {
            max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, memo[j]);
                }
            }
            memo[i] = max + 1;
            longest = Math.max(longest, memo[i]);
        }
        return longest;
    }
}