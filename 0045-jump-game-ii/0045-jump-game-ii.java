class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int jump = 0;
        int count = 0;
        while (jump < nums.length - 1) {
            count++;
            int temp = jump;
            while (i <= jump) {
                temp = Math.max(temp, i + nums[i]);
                i++;
            }
            jump = temp;
        }
        return count;
    }
}