class Solution {
    int[] word_scores, freq_letters;
    int[][] freq_words;
    public int maxScoreWords(int pos) {
        if(pos >= freq_words.length) return 0;
        int maxScore = maxScoreWords(pos + 1);

        for(int i = 0; i < 26; i++) {
            if(freq_words[pos][i] > freq_letters[i]) {
                return maxScore;
            }
        }

        for(int i = 0; i < 26; i++) {
            freq_letters[i] -= freq_words[pos][i];
        }

        maxScore = Math.max(maxScore, word_scores[pos] + maxScoreWords(pos + 1));

        for(int i = 0; i < 26; i++) {
            freq_letters[i] += freq_words[pos][i];
        }

        return maxScore;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        freq_letters = new int[26];
        word_scores = new int[n];
        freq_words = new int[n][26];
        for(char ch: letters) {
            freq_letters[ch - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            for(char ch: words[i].toCharArray()) {
                freq_words[i][ch - 'a']++;
                word_scores[i] += score[ch - 'a'];
            }
        }
        return maxScoreWords(0);
    }
}