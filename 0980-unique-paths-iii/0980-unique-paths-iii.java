class Solution {
    private int dfs(int[][] grid, int x, int y, int totalEmpty) {
        int m = grid.length, n = grid[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] < 0) {
            return 0;
        }

        if(grid[x][y] == 2) {
            return (totalEmpty == 0) ? 1 : 0;
        }

        int count = 0;
        grid[x][y] = -1;
        count += dfs(grid, x + 1, y, totalEmpty - 1);
        count += dfs(grid, x, y + 1, totalEmpty - 1);
        count += dfs(grid, x - 1, y, totalEmpty - 1);
        count += dfs(grid, x, y - 1, totalEmpty - 1);
        grid[x][y] = 0;
        return count;
    }
    public int uniquePathsIII(int[][] grid) {
        int totalEmpty = 0;
        int sx = 0, sy = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    totalEmpty++;
                }
                else if(grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            } 
        }

        return dfs(grid, sx, sy, totalEmpty + 1);
    }
}