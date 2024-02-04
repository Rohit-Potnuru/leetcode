class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int i = 0, j = k, len = 0;
        while(j < n) {
            if(word.charAt(i) != word.charAt(j)) {
                i = 0;
                len = 0;
            }
            if(word.charAt(i) == word.charAt(j)) {
                len++;
                i++;
            }
            j++;
        }
        n -= len;
        return (n + k - 1)/k;
    }
}