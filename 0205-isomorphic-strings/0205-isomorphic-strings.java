class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int n = s.length();
        int[] tFreq = new int[200];
        int[] sFreq = new int[200];
        for(int i = 0; i < n; i++) {
            int sIdx = s.charAt(i);
            int tIdx = t.charAt(i);
            if(tFreq[tIdx] != sFreq[sIdx]) {
                return false;
            }
            tFreq[tIdx] = i + 1;
            sFreq[sIdx] = i + 1;
        }
        return true;
    }
}