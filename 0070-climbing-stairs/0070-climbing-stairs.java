class Solution {
    public int climbStairs(int n) {
        int[] step = new int[2];
        step[0] = 1;
        step[1] = 2;
        if(n < 3) return step[n - 1];

        for(int i = 0; i < n - 2; i++) {
            step[1] += step[0];
            step[0] = step[1] - step[0];
        }
        return step[1];
    }
}