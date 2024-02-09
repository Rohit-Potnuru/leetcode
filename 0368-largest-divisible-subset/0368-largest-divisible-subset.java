class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max_len = 0, max_index = -1, num;
        Arrays.sort(nums);

        int[] memo = new int[n];
        for(int i = n - 1 ; i >= 0; i--) {
            memo[i]++;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] % nums[i] == 0) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }

            if(max_len < memo[i]) {
                max_len = memo[i];
                max_index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        num = nums[max_index];
        for(int i = 0; i < n; i++) {
            if(nums[i] % num == 0 && memo[i] == max_len) {
                res.add(nums[i]);
                max_len--;
                num = nums[i];
            }
        }
        return res;
    }
}