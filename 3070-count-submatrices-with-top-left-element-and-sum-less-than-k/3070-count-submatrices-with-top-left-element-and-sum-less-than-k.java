class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        if(grid[0][0] <= k) count++;
        else return 0;
        for(int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
            if(grid[i][0] <= k) count++;
        }
        for(int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
            if(grid[0][j] <= k) count++;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
                if(grid[i][j] <= k) count++;
                else break;
            }
        }
        return count;
    }
}