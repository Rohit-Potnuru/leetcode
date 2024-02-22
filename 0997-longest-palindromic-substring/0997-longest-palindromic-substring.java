public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        char[] charArray = s.toCharArray();
        String longest = s.substring(0,1);
        for(int i = 1; i < s.length(); ++i) {
            String s1 = getLongest(charArray, i, i);
            if(s1.length() > longest.length()) {
                longest = s1;
            }
            String s2 = getLongest(charArray, i-1, i);
            if(s2.length() > longest.length()) {
                longest = s2;
            }
        }
        return longest;
    }
    
    private String getLongest(char[] charArray, int low, int high) {
        while(low >= 0 && high <= (charArray.length-1) && charArray[low] == charArray[high]) {
            low--;
            high++;
        }
        String tmp = new String(charArray);
        return tmp.substring(i+1, j);
    }
}