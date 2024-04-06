class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch: s.toCharArray()) {
            if(ch == ')') {
                count--;
            }
            else if(ch == '(') {
                count++;
            }

            if(count >= 0) {
                stack.push(ch);
            }
            else {
                count = 0;
            }
        }

        StringBuilder st = new StringBuilder();
        while(!stack.isEmpty()) {
            char ch = stack.pop();
            if(count > 0 && ch == '(') {
                count--;
            }
            else {
                st.insert(0, ch);
            }
        }
        return st.toString();
    }
}