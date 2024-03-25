class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int num: nums) {
            sum += num;
            sum = Math.max(sum, num);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}