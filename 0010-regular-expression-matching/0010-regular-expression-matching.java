class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new int[m + 1][n +1];
        return isMatch(0,0,s,p);
    }


    boolean isMatch(int s1, int p1, String s, String p) {
        if(p1 == p.length()) {
            return s1 == s.length();
        }
        else if(memo[s1][p1] != 0) {
            return memo[s1][p1] == 1;
        } 
        boolean match = false;
        if(p1 + 1 != p.length() && p.charAt(p1 + 1) == '*') {
            match = isMatch(s1, p1 + 2, s, p);
            if(s1 != s.length() && !match && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.')) {
              match = isMatch(s1 + 1, p1, s, p);
            }
            memo[s1][p1] = match ? 1: 2;
            return match;
        }
        else {
            if(s1 != s.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.')) {
                match = isMatch(s1 + 1, p1 + 1, s, p);
            }
            memo[s1][p1] = match ? 1: 2;
            return match;
        }
    }
}