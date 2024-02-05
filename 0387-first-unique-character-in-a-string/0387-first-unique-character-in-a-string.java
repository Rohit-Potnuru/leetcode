class Solution {
    public int firstUniqChar(String s) {
        int[] uniqCh = new int[26];
        for(char ch: s.toCharArray()) {
            uniqCh[ch - 'a']++;
        } 

        for(int i = 0; i < s.length(); i++) {
            if(uniqCh[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}