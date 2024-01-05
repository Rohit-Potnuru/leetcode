class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Integer[] tempIntervals = new Integer[n];
        for(int i = 0; i < n; i++) {
            tempIntervals[i] = i;
        }
        Arrays.sort(tempIntervals, Comparator.comparingInt(i -> intervals[i][0]));

        int[] ans = new int[n];
        int mid, start, end;
        for(int i = 0; i < n; i++) {
            start = 0;
            end = n;
            while(start < end) {
                mid = (end - start)/2 + start;
                if(intervals[tempIntervals[mid]][0] < intervals[i][1]) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
            ans[i] = start == n ? -1: tempIntervals[start];
        }
        return ans;
    }
}