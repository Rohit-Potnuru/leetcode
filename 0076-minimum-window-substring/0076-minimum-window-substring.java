class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), uniqCount = 0;
        HashMap<Character, Integer> freqt = new HashMap<>();
        for(char ch: t.toCharArray()) {
            freqt.put(ch, freqt.getOrDefault(ch, 0) + 1);
            if(freqt.get(ch) == 1) {
                uniqCount++;
            }
        }

        int j = 0, i = 0;
        int minCount = Integer.MAX_VALUE, startMin = -1;
        char ch;
        HashMap<Character, Integer> freqs = new HashMap<>();
        while(j < n) {
            ch = s.charAt(j);
            freqs.put(ch, freqs.getOrDefault(ch, 0) + 1);
            if(freqs.get(ch).equals(freqt.getOrDefault(ch, 0))) {
                uniqCount--;
            }
            j++;

            while(uniqCount == 0) {
                if(minCount > j - i) {
                    minCount = j - i;
                    startMin = i;
                }

                ch = s.charAt(i);
                freqs.put(ch, freqs.get(ch) - 1);
                if(freqs.get(ch) < freqt.getOrDefault(ch, 0)) {
                    uniqCount++;
                }
                i++;
            }
        }
        
        return (startMin >= 0) ? s.substring(startMin, startMin + minCount): "";
    }
}
/*
   ADOBECODEBANC
   A
   AD
   ADO
   ADOB
   ADOBE
   ADOBEC
    DOBECO
*/