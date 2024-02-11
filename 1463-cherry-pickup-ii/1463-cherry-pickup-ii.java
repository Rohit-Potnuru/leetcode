class Solution {

    public int cherryPickup(int[][] grid) {        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = 0; c2 < n; c2++) {
                dp[m-1][c1][c2] = grid[m-1][c1] + (c1 == c2 ? 0 : grid[m-1][c2]);
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {
                    dp[i][c1][c2] = grid[i][c1] + (c1 == c2 ? 0 : grid[i][c2]);
                    int maxCandidate = 0;
                    for (int j1 = -1; j1 <=1; j1++) {
                        if (!inBounds(c1+j1, n)) {
                            continue;
                        }
                        for (int j2 = -1; j2 <= 1; j2++) {
                            if (!inBounds(c2+j2, n)) {
                                continue;
                            }
                            maxCandidate = Math.max(maxCandidate, dp[i+1][c1+j1][c2+j2]);
                        }
                    }
                    dp[i][c1][c2] += maxCandidate;
                }
            }
        }
        return dp[0][0][n-1];
    }

    private boolean inBounds(int c, int n) {
        return c >= 0 && c < n;
    }
}