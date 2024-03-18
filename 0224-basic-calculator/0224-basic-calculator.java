class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int number = 0, sign = 1, result = 0;
        while(i < n) {
            if(Character.isDigit(s.charAt(i))){
                number = number * 10 + (s.charAt(i) - '0');
            }
            else if(s.charAt(i) == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if(s.charAt(i) == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }
            else if(s.charAt(i) == '(') {
                st.push(result);
                st.push(sign);
                result = 0; 
                sign = 1;
            }
            else if(s.charAt(i) == ')') {
                result += sign * number;
                number = 0;
                result *= st.pop();
                result += st.pop();
            }
            i++;
        }
        return result + sign * number;
    }
}