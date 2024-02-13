class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Word[] headWords = new Word[26];
        Word curr, temp;
        for(String word : words) {
            temp = headWords[word.charAt(0) - 'a'];
            headWords[word.charAt(0) - 'a'] = new Word(word, 0, temp);
        }

        int count = 0;
        for(char ch: s.toCharArray()) {
            curr = headWords[ch - 'a'];
            while(curr != null) {
                headWords[ch - 'a'] = curr.next;
                temp = curr.next;

                curr.index++;
                if(curr.index == curr.word.length()) {
                    count++;
                }
                else {
                    curr.next = headWords[curr.word.charAt(curr.index) - 'a'];
                    headWords[curr.word.charAt(curr.index) - 'a'] = curr;
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