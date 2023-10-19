class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else {
                stack.push(s.charAt(i) );
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == '#') {
                if(!stack2.isEmpty())
                    stack2.pop();
            }
            else {
                stack2.push(t.charAt(i) );
            }
        }

        while(!stack.isEmpty() && !stack2.isEmpty()) {
            if(stack.pop() != stack2.pop())
                return false;
        }
        return stack.isEmpty() && stack2.isEmpty();
    }
}