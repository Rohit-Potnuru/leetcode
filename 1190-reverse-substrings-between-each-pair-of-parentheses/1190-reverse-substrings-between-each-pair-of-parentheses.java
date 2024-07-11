class Solution {
    int nextStart;
    private StringBuilder reverseParentheses(String s, int start) {
        StringBuilder st = new StringBuilder();
        for(int i = start; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                String temp = reverseParentheses(s, i + 1).reverse().toString();
                i = nextStart;
                st.append(temp);
            }
            else if(s.charAt(i) == ')') {
                nextStart = i;
                return st;
            }
            else {
                st.append(s.charAt(i));
            }
        }
        return st;
    }
    public String reverseParentheses(String s) {
        nextStart = 0;
        return reverseParentheses(s, 0).toString();
    }
}
