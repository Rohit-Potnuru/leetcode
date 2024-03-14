class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int currSum = 0, ans = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1;
        for(int num: nums) {
            currSum += num;
            if(currSum >= goal) {
                ans += prefixSum[currSum - goal];
            }
            prefixSum[currSum]++;
        }
        return ans;
    }
}