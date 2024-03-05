class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] yCellCount = new int[3];
        int[] nonYCellCount = new int[3];
        int yCells = 0, nonYCells = n*n;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((i >= n/2 && j == n/2) || 
                   (i < n/2 && (i == n - j - 1 || i == j))) {
                    yCellCount[grid[i][j]]++;
                    yCells++;
                }
                else {
                    nonYCellCount[grid[i][j]]++;
                }
            }
        }
        nonYCells -= yCells;
        
        int minCount = Integer.MAX_VALUE, total;
        for(int i = 0; i < 3; i++) {
            total = yCells - yCellCount[i] + nonYCells - Math.max(nonYCellCount[(i + 1)%3], nonYCellCount[(i + 2)%3]);
            minCount = Math.min(minCount, total);
        }
        return minCount;
    }
} 