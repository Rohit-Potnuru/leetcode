class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
        int n = nums.length;
        int start = 0, maxLen = 1;
        for(int i = 0; i < n; i++) {
            maxPQ.add(i);
            minPQ.add(i);
            while(nums[maxPQ.peek()] - nums[minPQ.peek()] > limit) {
                start++;
                while(maxPQ.peek() < start) {
                    maxPQ.poll();
                }
                while(minPQ.peek() < start) {
                    minPQ.poll();
                }
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}