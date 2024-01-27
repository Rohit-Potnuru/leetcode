// class Solution {
//     public int kInversePairs(int n, int k) {
//         final int MOD = 1000000007;
//         int[][] dp = new int[n + 1][k + 1];

//         for (int i = 1; i <= n; ++i) {
//             for (int j = 0; j <= k; ++j) {
//                 if (j == 0) {
//                     dp[i][j] = 1;
//                 } else {
//                     int val = (dp[i - 1][j] + MOD - (j - i >= 0 ? dp[i - 1][j - i] : 0)) % MOD;
//                     dp[i][j] = (dp[i][j - 1] + val) % MOD;
//                 }
//             }
//         }

//         return (dp[n][k] + MOD - (k > 0 ? dp[n][k - 1] : 0)) % MOD;
//     }
// }


class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
    public int kInversePairs(int n, int k) {
        if(k < 0 || k > n * (n  - 1)/2) return 0;
        if(n < 3) return 1;

        if(!dp.containsKey(n)) {
            dp.put(n, new HashMap<>());
        }
        else if(dp.get(n).containsKey(k)) {
            return dp.get(n).get(k);
        }
        
        int sum = 0;
        int MOD = 1000000007;
        if(k == 0) {
            sum = 1;
        }
        else {
            sum = (kInversePairs(n - 1, k) + MOD - ((k - n >= 0) ? kInversePairs(n - 1, k - n): 0)) % MOD;
            sum = (sum + kInversePairs(n, k - 1)) % MOD;
        }
        dp.get(n).put(k, sum);
        return sum;
    }
}