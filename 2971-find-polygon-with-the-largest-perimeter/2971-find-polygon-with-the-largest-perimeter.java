class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long max_peri = -1, sum = nums[0] + nums[1];
        for(int i = 2; i < n; i++) {
            if(nums[i] < sum) {
                max_peri = sum + nums[i];
            }
            sum += nums[i];
        }
        return max_peri;
    }
}