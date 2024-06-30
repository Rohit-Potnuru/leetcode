class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length, k = 2;
        int max = 0;
        for(int i = 0; i < k ; i++) {
            int[] memo = new int[k];
            for(int num: nums) {
                num = num % k;
                memo[num] = Math.max(memo[num], memo[(i + k - num)%k] + 1);
                max = Math.max(max, memo[num]);
            }
        }
        return max;
    }
}