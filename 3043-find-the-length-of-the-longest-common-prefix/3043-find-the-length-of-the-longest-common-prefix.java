class Trie {
    int total;
    boolean end;
    Trie[] children;
    public Trie() {
        this.end = false;
        this.children = new Trie[10];
    }
    
    public void insert(String num) {
        Trie curr = this;
        for(char ch: num.toCharArray()) {
            if(curr.children[ch - '0'] == null) {
                curr.children[ch - '0'] = new Trie();
            }
            curr = curr.children[ch - '0'];
        }
        curr.end = true;
    }
    
    public int search(String num) {
        int max = 0;
        Trie curr = this;
        for(char ch: num.toCharArray()) {
            if(curr.children[ch - '0'] == null) {
                return max;
            }
            max++;
            curr = curr.children[ch - '0'];
        }
        return max;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie numTrie = new Trie();
        for(int a: arr1) {
            numTrie.insert(String.valueOf(a));
        }
        int max = 0;
        for(int a: arr2) {
            max = Math.max(max, numTrie.search(String.valueOf(a)));
        }
        return max;
    }
}