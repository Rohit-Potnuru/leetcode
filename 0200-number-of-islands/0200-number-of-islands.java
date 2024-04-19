class Solution {
    private void dfs(int x, int y, char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        grid[x][y] = '0';
        for(int[] neighbor: new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
            int dx = x + neighbor[0];
            int dy = y + neighbor[1];
            if(0 <= dx && dx < rows && 0 <= dy && dy < cols && grid[dx][dy] == '1') {
                dfs(dx, dy, grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(grid[x][y] == '1') {
                    count++;
                    dfs(x, y, grid);
                }
            }
        }
        return count;
    }
}