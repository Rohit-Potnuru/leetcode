class Solution {
    public int rob(int[] nums) {
        int[] rob = new int[2];
        int maxRob = 0;
        int prev = 0, pprev = 0, ppprev = 0;
        for(int num: nums) {
            num = Math.max(Math.max(num + pprev, num + ppprev), num);
            maxRob = Math.max(maxRob, num);
            ppprev = pprev;
            pprev = prev;
            prev = num;
        }
        return maxRob;
    }
}