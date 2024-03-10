class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] set = new boolean[1001];
        for(int num: nums1) {
            set[num] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for(int num: nums2) {
            if(set[num]) {
                ans.add(num);
                set[num] = false;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}