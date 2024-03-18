class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> signSt = new Stack<>();
        st.push(0);
        signSt.push(1);
        int i = 0;
        int val, sign = 1;
        while(i < n) {
            if(s.charAt(i) == ' ') {

            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = (s.charAt(i) == '-') ? -1: 1;
            }
            else if(s.charAt(i) == '(') {
                st.push(0);
                signSt.push(sign);
                sign = 1;
            }
            else if(s.charAt(i) == ')') {
                st.push(st.pop() * signSt.pop() + st.pop());
            }
            else {
                val = 0;
                while(i < n && (s.charAt(i) == ' ' || Character.isDigit(s.charAt(i)))) {
                    if(s.charAt(i) != ' ') {
                        val = val * 10 + (s.charAt(i) - '0');
                    }
                    i++;
                }
                st.push(st.pop() + val * sign);
                i--;
            }
            i++;
        }
        return st.pop() * signSt.pop();
    }
}