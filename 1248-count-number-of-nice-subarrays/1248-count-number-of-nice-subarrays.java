class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0, curr = 0, oddCount = 0;
        int ans = 0, n = nums.length;
        while(curr < n) {
            // oddCount == k
            while(oddCount < k && curr < n) {
                if(nums[curr] % 2 == 1) {
                    oddCount++;
                }
                curr++;
            }

            // nextEvenCount
            int nextEvenCount = (oddCount < k) ? -1: 0;
            while(curr < n && nums[curr] % 2 != 1) {
                nextEvenCount++;
                curr++;
            }
            
            // prevEvenCount
            int prevEvenCount = 0;
            while(oddCount >= k && start < n) {
                if(nums[start] % 2 == 1) {
                    oddCount--;
                }
                else {
                    prevEvenCount++;
                }
                start++;
            }
            ans += (nextEvenCount + 1) * (prevEvenCount + 1);
        }
        return ans;
    }
}