class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String ch: tokens) {
            if(ch.equals("+")) {
                Integer num = stack.pop();
                stack.push(stack.pop() + num);
            }
            else if(ch.equals("-")) {
                Integer num = stack.pop();
                stack.push(stack.pop() - num);
            }
            else if(ch.equals("*")) {
                Integer num = stack.pop();
                stack.push(stack.pop() * num);
            }
            else if(ch.equals("/")) {
                Integer num = stack.pop();
                stack.push(stack.pop() / num);
            }
            else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.peek();
    }
}