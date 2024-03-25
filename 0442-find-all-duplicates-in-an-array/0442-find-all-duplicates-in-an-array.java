class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length, temp;
        HashSet<Integer> hashset = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                while(nums[i] != i + 1) {
                    if(nums[nums[i] - 1] == nums[i]) {
                        hashset.add(nums[i]);
                        break;
                    }
                    temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return new ArrayList<>(hashset);
    }
}