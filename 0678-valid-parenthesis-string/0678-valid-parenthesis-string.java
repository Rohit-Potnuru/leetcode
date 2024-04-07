class Solution {
    int[][] memo;
    public boolean dfs(int pos, int count, String s) {
        if(pos == s.length()) return count == 0;
        char ch = s.charAt(pos);
        if(count < 0) {
            return false;
        }
        else if(memo[pos][count] >= 0) {
            return memo[pos][count] == 1;
        }
        else if(ch == '*') {
            memo[pos][count] = dfs(pos + 1, count, s) || dfs(pos + 1, count - 1, s) || dfs(pos + 1, count + 1, s) ? 1: 0;
        }
        else if(ch == '(') {
            memo[pos][count] = dfs(pos + 1, count + 1, s) ? 1: 0;
        }
        else {
            memo[pos][count] = dfs(pos + 1, count - 1, s) ? 1: 0;
        }
        return memo[pos][count] == 1;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0, s);
    }
}