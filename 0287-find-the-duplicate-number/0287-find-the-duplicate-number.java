class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, j, temp;
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                j = nums[i];
                nums[i] = -1;
                while(nums[j - 1] >= 0) {
                    temp = nums[j - 1];
                    if(nums[j - 1] == j) {
                        return j;
                    }
                    nums[j - 1] = j;
                    j = temp;
                }
                nums[j - 1] = j;
            }
        }
        return -1;
    }
}