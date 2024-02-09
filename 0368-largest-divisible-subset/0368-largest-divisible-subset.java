class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max_len = 0, curr_len, curr_idx;
        Arrays.sort(nums);

        int[][] memo = new int[n][2];
        for(int i = n - 1 ; i >= 0; i--) {
            curr_len = 0;
            curr_idx = i;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] % nums[i] == 0) {
                    if(curr_len < memo[j][0]) {
                        curr_len = memo[j][0];
                        curr_idx = j;
                    }
                }
            }

            memo[i][0] = curr_len + 1;
            memo[i][1] = curr_idx;
            max_len = Math.max(max_len, memo[i][0]);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(memo[i][0] == max_len) {
                res.add(nums[i]);
                while(memo[i][1] != i) {
                    i = memo[i][1];
                    res.add(nums[i]);
                }
                return res;
            }
        }
        return res;
    }
}