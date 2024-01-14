class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if(n != word2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        byte[] bytes = new byte[n];

        word1.getBytes(0, n, bytes, 0);     
        for (byte b : bytes)  freq1[b - 'a']++;

        word2.getBytes(0, n, bytes, 0);     
        for (byte b : bytes)  freq2[b - 'a']++;

        for(int i = 0; i < 26; i++) {
            if(freq1[i] > 0 ^ freq2[i] > 0) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0; i < 26; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}