class Solution {
    public int maxScoreWords(int[][] freq_words, int pos, int[] score, int[] freq_letters) {
        if(pos >= freq_words.length) return 0;
        int maxScore = maxScoreWords(freq_words, pos + 1, score, freq_letters);

        for(int i = 0; i < 26; i++) {
            if(freq_words[pos][i] > freq_letters[i]) {
                return maxScore;
            }
        }
        int word_score = 0;
        for(int i = 0; i < 26; i++) {
            word_score += score[i] * freq_words[pos][i];
            freq_letters[i] -= freq_words[pos][i];
        }

        maxScore = Math.max(maxScore, word_score + maxScoreWords(freq_words, pos + 1, score, freq_letters));

        for(int i = 0; i < 26; i++) {
            freq_letters[i] += freq_words[pos][i];
        }

        return maxScore;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] freq_letters = new int[26];
        int[][] freq_words = new int[n][26];
        for(char ch: letters) {
            freq_letters[ch - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            for(char ch: words[i].toCharArray()) {
                freq_words[i][ch - 'a']++;
            }
        }
        return maxScoreWords(freq_words, 0, score, freq_letters);
    }
}