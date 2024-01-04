class Solution {
    private int lowerBound(int[] nums, int target) {
        int start = 0, end = nums.length, mid;
        while(start < end) {
            mid = (end - start)/2 + start;
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
    private int upperBound(int[] nums, int target) {
        int start = 0, end = nums.length, mid;
        while(start < end) {
            mid = (end - start)/2 + start;
            if(nums[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }

    public int[] searchRange(int[] nums, int target) {
        int upper = upperBound(nums, target), lower = lowerBound(nums, target);
        if(upper == lower) return new int[] {-1, - 1};
        return new int[] {lower, upper - 1};
    }
}