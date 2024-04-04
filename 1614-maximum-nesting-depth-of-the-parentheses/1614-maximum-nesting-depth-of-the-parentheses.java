class Solution {
    public int maxDepth(String s) {
        int count = 0, maxCount = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                count++;
            }
            else if(ch == ')') {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}