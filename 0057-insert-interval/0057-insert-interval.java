class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0, size = -1;
        while(i < n) {
            if(newInterval[0] <= intervals[i][1]) break;
            ans.add(intervals[i]);
            i++;
            size++;
        }
        ans.add(newInterval);
        size++;
        while(i < n) {
            if(Math.max(intervals[i][0], ans.get(size)[0]) <= Math.min(intervals[i][1], ans.get(size)[1])) {
                ans.get(size)[0] = Math.min(intervals[i][0], ans.get(size)[0]);
                ans.get(size)[1] = Math.max(intervals[i][1], ans.get(size)[1]);
            }
            else {
                ans.add(intervals[i]);
                size++;
            }
            i++;
        }
        return ans.toArray(new int[size + 1][]);
    }
}