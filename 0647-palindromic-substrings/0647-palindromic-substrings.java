class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), upper;
        int count = n;
        for(int i = 0; i < n; i++) {
            upper = Math.min(i + 1, n - i);
            for(int j = 1; j < upper; j++) {
                if(s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                count++;
            }

            upper = Math.min(i + 1, n - i - 1);
            for(int j = 0; j < upper; j++) {
                if(s.charAt(i - j) != s.charAt(i + j + 1)) {
                    break;
                }
                count++;
            }
        }
        return count;
    }
}