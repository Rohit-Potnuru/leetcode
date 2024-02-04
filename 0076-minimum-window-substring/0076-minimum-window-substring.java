class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] freqt = new int[128];
        int len_t = t.length();
        for(char ch: t.toCharArray()) {
            freqt[ch]++;
        }   

        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE, startIndex = -1;
        while(end < n) {
            if(freqt[s.charAt(end++)]-- > 0) {
                len_t--;
            }

            while(len_t == 0) {
                if(minLen > end - start) {
                    startIndex = start;
                    minLen = end - start;
                }

                if(freqt[s.charAt(start++)]++ == 0) {
                    len_t++;
                }
            }
        }
        return (startIndex >= 0) ? s.substring(startIndex, startIndex + minLen): "";
    }
}
/*
   ADOBECODEBANC
   A
   AD
   ADO
   ADOB
   ADOBE
   ADOBEC
    DOBECO
*/