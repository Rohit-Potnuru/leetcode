class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0, prev = 0;
        for(char ch: s.toCharArray()) {
            if(ch == ' ') {
                if(len != 0) prev = len;
                len = 0;
            }
            else {
                len++;
            }
        }
        if(len != 0) prev = len;
        return prev;
    }
}