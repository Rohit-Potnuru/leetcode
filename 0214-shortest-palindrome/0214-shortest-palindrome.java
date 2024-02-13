class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] lsp = new int[n];
        lsprefix(s.toCharArray(), lsp);
        int start = 0;
        int end = n - 1;

        while(end >= 0) {
            if(s.charAt(start) == s.charAt(end)) {
                end--;
                start++;
            }
            else {
                if(start != 0) {
                    start = lsp[start - 1];
                }
                else {
                    end--;
                }
            }
        }

        return new StringBuilder(s.substring(start)).reverse().toString() + s;
    }

    public void lsprefix(char[] p, int[] lsp) {
        int n = p.length, start = 0, end = 1;
        while(end < n) {
            if(p[start] == p[end]) {
                lsp[end++] = ++start;
            }
            else {
                if(start != 0) {
                    start = lsp[start - 1];
                }
                else {
                    lsp[end++] = start;
                }
            }
        }
    }
}