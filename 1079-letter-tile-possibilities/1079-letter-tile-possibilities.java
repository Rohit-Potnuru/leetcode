class Solution {
    public int totalPermutation(int[] freq) {
        int total = 1;
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                freq[i] -= 1;
                total += totalPermutation(freq);
                freq[i] += 1;
            } 
        }
        return total;
    }
    
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(int i = 0; i < tiles.length(); i++) {
            freq[tiles.charAt(i) - 'A'] += 1;
        }

        return totalPermutation(freq) - 1;
    }
}