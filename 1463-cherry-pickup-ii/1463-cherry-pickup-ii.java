class Solution {
    private int[][] grid;
    private Integer[][][] memo;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int m = grid[0].length;
        this.memo = new Integer[n][m][m];
        return dp(0, 0, m - 1);
    }

    private int dp(int r, int c1, int c2) {
        int n = grid.length;
        int m = grid[0].length;
        if (r == n) return 0; // Base case: beyond the last row
        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) return 0; // Out of bounds
        if (memo[r][c1][c2] != null) return memo[r][c1][c2]; // Use memoized result if available

        // Calculate cherries picked by both robots at the current cell
        int cherries = grid[r][c1];
        if (c1 != c2) cherries += grid[r][c2]; // Add cherries from the second robot if it's in a different column

        // Try all movements for both robots to the next row
        int maxCherries = 0;
        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {
                int nextC1 = c1 + move1;
                int nextC2 = c2 + move2;
                maxCherries = Math.max(maxCherries, cherries + dp(r + 1, nextC1, nextC2));
            }
        }

        memo[r][c1][c2] = maxCherries; // Memoize the result
        return maxCherries;
    }
}
