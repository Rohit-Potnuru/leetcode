class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder st = new StringBuilder();
        int ones = -1;
        for(char ch: s.toCharArray()) {
            if(ch - '0' == 1) ones++;
            if(ones > 0) st.append("1");
        }

        for(int i = 0; i < s.length() - ones - 1; i++) {
            st.append("0");
        }
        st.append("1");

        return st.toString();
    }
}