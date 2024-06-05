class Solution {
    private int[] freqWord(String word) {
        int[] freq = new int[26];
        for(char ch: word.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }

    public List<String> commonChars(String[] words) {
        if(words == null || words.length == 0) return Collections.emptyList();
        int[] freq = freqWord(words[0]);
        for(String word: words) {
            int[] temp = freqWord(word);
            for(int i = 0; i < temp.length; i++) {
                freq[i] = Math.min(temp[i], freq[i]);
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                ans.addAll(Collections.nCopies(freq[i], String.valueOf((char)(i + 'a'))));
            }
        }

        return ans;
    }
}