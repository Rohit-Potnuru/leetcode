class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, prev = -1;
        for(int num: nums) {
            if(prev >= num) {
                sum += Math.abs(prev - num) + 1;
                num = prev + 1;
            }
            prev = num;
        }
        return sum;
    }
}