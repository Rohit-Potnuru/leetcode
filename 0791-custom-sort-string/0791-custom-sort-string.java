class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for(char ch: order.toCharArray()) {
            ans.append(String.valueOf(ch).repeat(freq[ch - 'a']));
            freq[ch - 'a'] = 0;
        }
        for(int i = 0; i < 26; i++) {
            ans.append(String.valueOf((char)('a' + i)).repeat(freq[i]));
        }
        return ans.toString();
    }
}