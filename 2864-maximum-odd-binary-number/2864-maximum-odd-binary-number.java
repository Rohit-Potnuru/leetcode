class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = -1, curr = 0, n = s.length();
        char[] st = s.toCharArray();
        for(int i = 0; i < n; i++) {
            if(st[i] - '0' == 1) {
                if(ones == -1) ones++;
                else st[ones++] = '1';
            }
            st[i] = '0';
        }

        st[n - 1] = '1';

        return new String(st);
    }
}

