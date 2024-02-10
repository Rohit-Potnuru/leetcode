class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), j;
        int count = 0;
        for(int i = 0; i < n; i++) {
            j = 0;
            while(i - j >= 0 
                  && i + j < n 
                  && s.charAt(i - j) == s.charAt(i + j)) {
                count++;
                j++;
            }
            
            j = 0;
            while(i - j >= 0 
                  && i + j + 1 < n 
                  && s.charAt(i - j) == s.charAt(i + j + 1)) {
                count++;
                j++;
            }
        }
        return count;
    }
}