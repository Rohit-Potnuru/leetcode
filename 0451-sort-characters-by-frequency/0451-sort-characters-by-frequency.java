class Solution {
    public String frequencySort(String s) {
        StringBuilder[] freqSB = new StringBuilder[128];
        for(char ch: s.toCharArray()) {
            if(freqSB[ch] == null) {
                freqSB[ch] = new StringBuilder();
            }
            freqSB[ch].append(ch);
        }

        Arrays.sort(freqSB, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder s1, StringBuilder s2) {
                if(s1 == null) return 1;
                else if(s2 == null) return -1;
                else return s2.length() - s1.length();
            }
        });

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 128; i++) {
            if(freqSB[i] == null) {
                break;
            }
            res.append(freqSB[i]);
        }    
        return res.toString();
    }
}