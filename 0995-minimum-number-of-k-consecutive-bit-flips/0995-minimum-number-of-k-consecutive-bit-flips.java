class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n + 1];
        int flipCount = 0, ans = 0;
        for(int i = 0; i < n; i++) {
            flipCount += flip[i];
            int num = (nums[i] + flipCount)%2;
            if(num == 0) {
                ans++;
                flip[i]++;
                flipCount++;
                if(i + k <= n) {
                    flip[i + k]--;
                }
                else {
                    return -1;
                }
            }
        }
        return ans;
    }
}