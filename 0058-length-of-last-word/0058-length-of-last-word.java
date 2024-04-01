class Solution {
    public int lengthOfLastWord(String s) {
        int len = 1, i = 1, n = s.length();
        for(i = 1; i < n; i++) {
            if(s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                len = 1;
            }
            else if(s.charAt(i) != ' '){
                len++;
            }
        }
        return len;
    }
}