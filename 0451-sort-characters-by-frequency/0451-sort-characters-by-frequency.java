class Solution {
    public String frequencySort(String s) {
        StringBuilder[] freqSB = new StringBuilder[128];
        for(int i = 0; i < 128; i++) {
            freqSB[i] = new StringBuilder();
        }
        for(char ch: s.toCharArray()) {
            freqSB[ch].append(ch);
        }

        Arrays.sort(freqSB, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder s1, StringBuilder s2) {
                return s2.length() - s1.length();
            }
        });

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 128; i++) {
            if(freqSB[i].length() == 0) {
                break;
            }
            res.append(freqSB[i]);
        }    
        return res.toString();
    }
}