class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int prev = nums[0] - 1;
        int prevCount = 0;
        for(int num: nums) {
            if(prev != num) {
                if(prevCount == 1) return -1;
                count += prevCount/3 + (prevCount%3 + 1)/2;
                prevCount = 0;
                prev = num;
            }
            prevCount++;
        }
        if(prevCount == 1) return -1;
        count += prevCount/3 + (prevCount%3 + 1)/2;
        return count;
    }
}