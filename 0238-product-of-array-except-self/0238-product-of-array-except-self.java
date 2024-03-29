class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}