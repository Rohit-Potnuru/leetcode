class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] freq = new int[26], tempFreq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int fullcount = 0, uniqCount = 0, prev = -1;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            tempFreq[ch - 'a']++;
            if(tempFreq[ch - 'a'] == 1) uniqCount++;
            if(tempFreq[ch - 'a'] == freq[ch - 'a']) fullcount++;
            if(fullcount == uniqCount) {
                res.add(i - prev);
                prev = i;
                for(int j = 0; j < 26; j++) tempFreq[j] = 0;
            }
        }    
        return res;    
    }
}