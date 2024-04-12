class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> mono_stack;
        int count = 0, idx = 0, i, prev = 0;
        for(auto h:height){
            while(!mono_stack.empty() && height[mono_stack.top()] <= h){
                i = mono_stack.top();
                count += (height[i] - prev)* (idx - i - 1);
                prev = height[i];
                mono_stack.pop();
            }
            
            if(!mono_stack.empty()){
                count += (h - prev) * (idx - mono_stack.top() - 1);
            }
            
            mono_stack.push(idx);
            prev = h;
            idx++;
        }
        return count;
    }
};