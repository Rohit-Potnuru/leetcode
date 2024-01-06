class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> memo = new ArrayList<>();

        int max = 0, longest = 1;
        for(int i = 0; i < n; i++) {
            int mid, start = 0, end = memo.size();
            while(start < end) {
                mid = (end - start)/2 + start;
                if(memo.get(mid) < nums[i]) {
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }
            if(memo.size() == start) {
                memo.add(nums[i]);
            }
            memo.set(start, nums[i]);
        }
        return memo.size();
    }
}