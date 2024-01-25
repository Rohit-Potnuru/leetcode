class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[] dp = new int[n2];
        int prev, u_prev, temp;
        int max = 0;
        for(int i = 0; i < n1; i++) {
            prev = 0;
            u_prev = 0;
            temp = 0;
            for(int j = 0; j < n2; j++) {
                temp = dp[j];
                // System.out.println(text1.charAt(i) +" " + text2.charAt(j) + " " + text1.charAt(i) == text2.charAt(j) +" " + i + " " + j);
                dp[j] = Math.max(prev, dp[j]);
                if(text1.charAt(i) == text2.charAt(j)) {
                    // System.out.println(text1.charAt(i) + " " + i + " " + j);
                    dp[j] = Math.max(u_prev + 1, dp[j]);
                }
                max = Math.max(max, dp[j]);
                prev = dp[j];
                u_prev = temp;
            }
        }
        return max;
    }
}

// ubmrapg
// ezupkr