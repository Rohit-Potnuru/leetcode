class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = 0, j = n;
        int count = 0;
        while (i < m) {
            if(j != 0 && grid[i][j - 1] < 0) {
                j--;
            }
            else {
                count += n - j;
                i++;
            }
        }
        return count;
    }
}