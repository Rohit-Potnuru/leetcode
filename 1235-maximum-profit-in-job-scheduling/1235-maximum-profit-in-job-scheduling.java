class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i;
        }

        Arrays.sort(nums, Comparator.comparingInt(i -> endTime[i]));
        for(int i = 1; i < n; i++) {
            int mid, start = 0, end = i;
            while(start < end) {
                mid = (end - start)/2 + start;
                if(endTime[nums[mid]] <= startTime[nums[i]]) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
            if(start != 0) {
                profit[nums[i]] += profit[nums[start - 1]];
            }
            profit[nums[i]] = Math.max(profit[nums[i - 1]], profit[nums[i]]);
        }
        return profit[nums[n - 1]];
    }
}