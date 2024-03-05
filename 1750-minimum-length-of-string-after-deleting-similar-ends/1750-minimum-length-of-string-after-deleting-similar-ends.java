class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int start = 0, end = n - 1;
        while(start < end) {
            char strChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(strChar != endChar || start >= end) break;
            while(start < n  && strChar == s.charAt(start)) {
                start += 1;
            }

            while(end >= 0  && endChar == s.charAt(end)) {
                end -= 1;
            }
        }
        return end - start + 1 > 0? end - start + 1: 0;
    }
}