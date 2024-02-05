class Solution {
    public int firstUniqChar(String s) {
        int n = s.length(), temp;
        int[] uniqCh = new int[26];
        for(int i = 0; i < n; i++) {
            temp = s.charAt(i) - 'a';
            if(uniqCh[temp] != 0) {
                uniqCh[temp] = -1;
            }
            else {
                uniqCh[temp] = i + 1;
            }
        }

        temp = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(uniqCh[i] > 0) {
                temp = Math.min(temp, uniqCh[i] - 1);
            }
        }
        return (temp == Integer.MAX_VALUE) ? -1: temp;
    }
}