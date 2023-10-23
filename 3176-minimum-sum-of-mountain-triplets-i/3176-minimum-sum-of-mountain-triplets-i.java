class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int prev = nums[n - 1];
        for(int i = n - 1; i >= 0; i--) {
            temp[i] = Math.min(nums[i], prev);
            prev = temp[i];
        }
        
        int minSum = Integer.MAX_VALUE;
        prev = nums[0];
        for(int i = 1; i < n - 1; i++) {
            if(nums[i] > prev && nums[i] > temp[i + 1]) {
                minSum = Math.min(minSum, nums[i] + prev + temp[i + 1]);
            }
            prev = Math.min(prev, nums[i]);
        }
        
        if(minSum == Integer.MAX_VALUE)
                return -1;
        return minSum;
    }
}