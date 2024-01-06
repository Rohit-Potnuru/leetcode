class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] nums = new int[n][3];
        for(int i = 0; i < n; i++) {
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }

        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        for(int i = 1; i < n; i++) {
            int mid, start = 0, end = i;
            while(start < end) {
                mid = (end - start)/2 + start;
                if(nums[mid][1] <= nums[i][0]) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
            if(start != 0) {
                nums[i][2] += nums[start - 1][2];
            }
            nums[i][2] = Math.max(nums[i - 1][2], nums[i][2]);
        }
        return nums[n - 1][2];
    }
}