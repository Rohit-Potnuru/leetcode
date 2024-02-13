class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Word[] headWords = new Word[26];
        Word curr, temp;
        int i;
        for(String word : words) {
            i = word.charAt(0) - 'a';
            temp = headWords[i];
            headWords[i] = new Word(word, 0, temp);
        }

        int count = 0;
        for(char ch: s.toCharArray()) {
            i = ch - 'a';
            curr = headWords[i];
            headWords[i] = null;
            while(curr != null) {
                temp = curr.next;

                curr.index++;
                if(curr.index == curr.word.length()) {
                    count++;
                    curr.next = null;
                }
                else {
                    i = curr.word.charAt(curr.index) - 'a';
                    curr.next = headWords[i];
                    headWords[i] = curr;
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
        Word(String word, int index, Word next) {
            this.word = word;
            this.index = index;
            this.next = next;
        }
    }
}