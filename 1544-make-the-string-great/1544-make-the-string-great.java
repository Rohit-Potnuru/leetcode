class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack();
        for(char ch: s.toCharArray()) {
            if(!st.isEmpty() && Math.abs(ch - st.peek()) == 32) {
                st.pop();
            }
            else {
                st.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        
        return result.toString();
    }
}