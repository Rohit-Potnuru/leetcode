class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int count = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue; 
                }
                int diffInt = (int) diff;
                if(!dp[i].containsKey(diffInt)) {
                    dp[i].put(diffInt, 0);
                }
                dp[i].put(diffInt, dp[i].get(diffInt) + 1);

                if(dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    count += dp[j].get(diffInt);
                }
            }
        }
        return count;
    }
}
