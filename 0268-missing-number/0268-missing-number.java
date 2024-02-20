class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, temp;
        for(int i = 0; i < n; i++) {
            nums[i]++;
        }

        for(int i = 0; i < n; i++) {
            temp = Math.abs(nums[i]) - 1;
            if(temp < n && nums[temp] > 0) {
                nums[temp] *= -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i;
            }
        }
        return n;
    }
}