class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder st = new StringBuilder();
        int ones = 0;
        for(char ch: s.toCharArray()) {
            if(ch - '0' == 1) ones++;
        }

        for(int i = 0; i < ones - 1; i++) {
            st.append("1");
        }
        for(int i = 0; i < s.length() - ones; i++) {
            st.append("0");
        }
        st.append("1");

        return st.toString();
    }
}