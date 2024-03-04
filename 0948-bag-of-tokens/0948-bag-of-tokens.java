class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int score = 0, maxScore = 0, start = 0, end = n - 1;
        Arrays.sort(tokens);
        while(start <= end) {
            if(power >= tokens[start]) {
                power -= tokens[start++];
                score++;
            }
            else if(score > 0) {
                power += tokens[end--];
                score--;
            }
            else {
                break;
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}