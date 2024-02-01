class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] res = new int[n/3][3];
        int max = 0, min = 0;
        for(int i = 0; i < n/3; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for(int j = 0; j < 3; j++) {
                res[i][j] = nums[3 * i + j];
                max = Math.max(max, res[i][j]);
                min = Math.min(min, res[i][j]);
            }
            if(max - min > k) {
                System.out.println(min + " " + max);
                return new int[0][0];
            }
        }
        return res;
    }
}