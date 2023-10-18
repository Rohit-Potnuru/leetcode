class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] stack = new int[n];
        int[] ans = new int[n];
        int length = 0;

        for(int i = 0; i < n; i++) {
            int start = 0, end = length;
            while(start < end) {
                int mid = start + (end - start)/2;
                if(stack[mid] <= obstacles[i])
                    start = mid + 1;
                else
                    end = mid;
            }
            if(start == length) {
                length++;
            }
            stack[start] = obstacles[i];
            ans[i] = start + 1;
        }
        return ans;
    }
}