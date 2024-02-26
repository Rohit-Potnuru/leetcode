class Solution {
    public boolean validate(int[] nums, int[] changeIndices, int pos) {
        int n = nums.length;
        HashMap<Integer, Integer> lastIndices = new HashMap<>();
        for(int i = 0; i < pos; i++) {
            lastIndices.put(changeIndices[i], i);
        }

        if(lastIndices.size() != n) return false;
        int count = 0;
        for(int i = 0; i < pos; i++) {
            if(i == lastIndices.get(changeIndices[i])) {
                if(count < nums[changeIndices[i] - 1]) return false;
                else count -= nums[changeIndices[i] - 1];
            }
            else {
                count++;
            }
        }
        return true;
    }

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int cin = changeIndices.length;

        int min = -1;

        int start = 0, end = cin + 1;
        while(start < end) {
            int mid = (end - start)/2 + start;
            if(validate(nums, changeIndices, mid)) {
                min = mid;
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return min;
    }
}