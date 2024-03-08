class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxCount = 0;
        int totalElement = 0;
        int[] freq = new int[101];
        for(int num: nums) {
            freq[num] += 1;
            if(freq[num] > maxCount) {
                totalElement = 0;
                maxCount = freq[num];
            }
            if(freq[num] == maxCount) totalElement++;
        }
        return totalElement * maxCount;
    }
}