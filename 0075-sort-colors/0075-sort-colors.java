class Solution {
    public void sortColors(int[] nums) {
        int i = 0, n = nums.length;
        for(int j = 0; j < n; j++) {
            if(nums[j] == 0) {
                nums[j] = nums[i];
                nums[i++] = 0; 
            }
        }
        for(int j = 0; j < n; j++) {
            if(nums[j] == 1) {
                nums[j] = nums[i];
                nums[i++] = 1; 
            }
        }
    }
}