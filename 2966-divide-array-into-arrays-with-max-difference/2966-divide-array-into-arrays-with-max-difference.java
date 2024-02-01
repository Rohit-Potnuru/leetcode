class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] res = new int[n/3][3];
        int prev = -1, max = 0, min = 0;
        for(int i = 0; i < n; i++) {
            if(prev != i/3) {
                if(max - min > k) {
                    return new int[0][0];
                }
                max = nums[i];
                min = nums[i];
            }
            res[i/3][i%3] = nums[i];
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            prev = i/3;
        }
        if(max - min > k) {
            return new int[0][0];
        }
        return res;
    }
}