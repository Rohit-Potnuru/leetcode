class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long max_peri = -1, sum = 0;
        for(int i = 0; i < n; i++) {
            if(i > 1 && nums[i] < sum) {
                max_peri = sum + nums[i];
            }
            sum += nums[i];
        }
        return max_peri;
    }
}