class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder st = new StringBuilder();
        int ones = 0;
        for(char ch: s.toCharArray()) {
            if(ch - '0' == 1) {
                ones++;
            }
        }

        st.append("1".repeat(ones - 1));
        st.append("0".repeat(s.length() - ones));
        st.append("1");

        return st.toString();
    }
}