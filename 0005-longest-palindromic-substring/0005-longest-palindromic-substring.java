class Solution {
    public String longestPalindrome(String s) {
        int maxi = 0, maxj = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int j = 0;
            while(i + j < n && i - j >= 0 && s.charAt(i + j) == s.charAt(i - j)) {
                j++;
            }
            j--;
            if(maxj - maxi + 1 < 2 * j + 1) {
                maxj = i + j;
                maxi = i - j;
            }
            j = 0;
            while(i + j + 1 < n && i - j >= 0 && s.charAt(i + j + 1) == s.charAt(i - j)) {
                j++;
            }
            j--;
            if(maxj - maxi + 1 < 2 * j + 2) {
                maxj = i + j + 1;
                maxi = i - j;
            }
        }
        return s.substring(maxi, maxj + 1);
    }
}