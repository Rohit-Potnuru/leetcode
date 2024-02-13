class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] freq = new int[26], tempFreq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int uniqCount = 0, prev = -1, idx;
        for(int i = 0; i < n; i++) {
            idx = s.charAt(i) - 'a';
            tempFreq[idx]++;
            if(tempFreq[idx] == 1) uniqCount++;
            if(tempFreq[idx] == freq[idx]) uniqCount--;
            if(uniqCount == 0) {
                res.add(i - prev);
                prev = i;
                for(int j = 0; j < 26; j++) tempFreq[j] = 0;
            }
        }    
        return res;    
    }
}