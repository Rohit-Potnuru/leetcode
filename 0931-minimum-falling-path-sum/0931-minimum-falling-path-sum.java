class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int min = 0, temp;
        for(int i = 0; i < m; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(i > 0) {
                    temp = matrix[i - 1][j];
                    if(j > 0) temp = Math.min(temp, matrix[i - 1][j - 1]);
                    if(j < n - 1) temp = Math.min(temp, matrix[i - 1][j + 1]);
                    matrix[i][j] += temp;
                }
                min = Math.min(min, matrix[i][j]);
            }
        }
        return min;
    }
}