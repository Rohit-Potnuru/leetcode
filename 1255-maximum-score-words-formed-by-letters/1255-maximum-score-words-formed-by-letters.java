class Solution {
    public int maxScoreWords(int pos, int[][] freq_words, int[] word_scores, int[] freq_letters) {
        if(pos >= freq_words.length) return 0;
        int maxScore = maxScoreWords(pos + 1, freq_words, word_scores, freq_letters);

        for(int i = 0; i < 26; i++) {
            if(freq_words[pos][i] > freq_letters[i]) {
                return maxScore;
            }
        }

        for(int i = 0; i < 26; i++) {
            freq_letters[i] -= freq_words[pos][i];
        }

        maxScore = Math.max(maxScore, word_scores[pos] + maxScoreWords(pos + 1, freq_words, word_scores, freq_letters));

        for(int i = 0; i < 26; i++) {
            freq_letters[i] += freq_words[pos][i];
        }

        return maxScore;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] freq_letters = new int[26];
        int[][] freq_words = new int[n][26];
        int[] word_scores = new int[n];
        for(char ch: letters) {
            freq_letters[ch - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            for(char ch: words[i].toCharArray()) {
                freq_words[i][ch - 'a']++;
                word_scores[i] += score[ch - 'a'];
            }
        }
        return maxScoreWords(0, freq_words, word_scores, freq_letters);
    }
}