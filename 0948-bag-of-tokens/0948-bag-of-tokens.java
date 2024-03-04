class Solution {
    int[][] dpScores;
    public int bagOfTokkensScore(int power, int score, int[]tokens, int start, int end) {
        if(start > end) return score;
        if(dpScores[start][end] >= 0) return dpScores[start][end];
        int tempScore = score;
        if(score > 0) {
            tempScore = Math.max(tempScore, bagOfTokkensScore(power + tokens[end], score - 1, tokens, start, end - 1));
        }
        if(power >= tokens[start]) {
            tempScore = Math.max(tempScore, bagOfTokkensScore(power - tokens[start], score + 1, tokens, start + 1, end));
        }
        dpScores[start][end] = tempScore;
        return tempScore;
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        dpScores = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dpScores[i][j] = -1;
            }
        }
        Arrays.sort(tokens);
        return bagOfTokkensScore(power, 0, tokens, 0, n - 1);
    }
}
