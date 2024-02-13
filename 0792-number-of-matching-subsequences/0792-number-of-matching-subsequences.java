class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Word[] headWords = new Word[26];
        Word curr, temp;
        for(int i = 0; i < 26; i++) headWords[i] = new Word("", 0, null);
        for(String word : words) {
            temp = headWords[word.charAt(0) - 'a'].next;
            headWords[word.charAt(0) - 'a'].next = new Word(word, 0, temp);
        }

        int count = 0;
        for(char ch: s.toCharArray()) {
            curr = headWords[ch - 'a'].next;
            headWords[ch - 'a'].next = null;
            while(curr != null) {
                temp = curr.next;

                curr.index++;
                if(curr.index == curr.word.length()) {
                    count++;
                    curr.next = null;
                }
                else {
                    curr.next = headWords[curr.word.charAt(curr.index) - 'a'].next;
                    headWords[curr.word.charAt(curr.index) - 'a'].next = curr;
                }
                curr = temp;
            }
        }
        return count;
    }

    class Word {
        String word;
        int index;
        Word next;
        Word(String word, int index) {
            this.word = word;
            this.index = index;
            this.next = null;
        }
        Word(String word, int index, Word next) {
            this.word = word;
            this.index = index;
            this.next = next;
        }
    }
}