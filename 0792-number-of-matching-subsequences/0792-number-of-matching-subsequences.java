class Solution {
    boolean isSubsequence(String s, String t) {
        int n = t.length(), start = 0;
        for(char ch: s.toCharArray()) {
            if(ch == t.charAt(start)) {
                start++;
            }
            if(start == n) {
                return true;
            }
        }
        return false;
    }
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(String word: words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }
        
        for(String word: hashmap.keySet()) {
            if(isSubsequence(s, word)) {
                count += hashmap.get(word);
            }
        }
        return count;
    }
}