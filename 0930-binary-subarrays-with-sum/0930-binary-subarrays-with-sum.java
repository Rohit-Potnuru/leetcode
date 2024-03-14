class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int currSum = 0, ans = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1;
        for(int num: nums) {
            currSum += num;
            ans += (currSum >= goal)? prefixSum[currSum - goal] : 0;
            prefixSum[currSum]++;
        }
        return ans;
    }
}