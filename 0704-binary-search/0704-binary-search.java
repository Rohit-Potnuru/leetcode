class Solution {
    public int search(int[] nums, int target) {
        int mid, start = 0, end = nums.length;
        while(start < end) {
            mid = (end - start)/2 + start;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return -1;
    }
}