class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int trapWater = 0, n = height.length;
        for(int i = 0; i < n; i++) {
            int prevH = 0;
            int curr = i;
            while(!st.isEmpty() && height[st.peek()] <= height[i]) {
                curr = st.pop();
                trapWater += (i - curr - 1) * (height[curr] - prevH);
                prevH = height[curr];
            }
            if(!st.isEmpty()) {
                trapWater += (i - st.peek() - 1) * (height[i] - prevH);
            }
            st.push(i);
        }
        return trapWater;
    }
}