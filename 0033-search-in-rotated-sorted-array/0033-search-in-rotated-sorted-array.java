class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int mid, start = 0, end = n;
        while(start < end) {
            mid = (end - start)/2 + start;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[start] < nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(nums[mid] < target && target < nums[start]) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}