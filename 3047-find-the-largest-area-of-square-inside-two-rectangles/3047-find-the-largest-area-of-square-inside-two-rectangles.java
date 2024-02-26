class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int xli, xlj, xti, xtj, yli, ylj, yti, ytj, X, Y;
        for(int i = 0; i < bottomLeft.length; i++) {
            xli = bottomLeft[i][0];
            yli = bottomLeft[i][1];
            xti = topRight[i][0];
            yti = topRight[i][1];
            for(int j = i + 1; j < bottomLeft.length; j++) {
                xlj = bottomLeft[j][0];
                ylj = bottomLeft[j][1];
                xtj = topRight[j][0];
                ytj = topRight[j][1];

                X = Math.min(xtj, xti) - Math.max(xlj, xli);
                Y = Math.min(ytj, yti) - Math.max(ylj, yli);
                
                max = Math.max(max, Math.min(X, Y));
            }
        }
        return max * max;
    }
}