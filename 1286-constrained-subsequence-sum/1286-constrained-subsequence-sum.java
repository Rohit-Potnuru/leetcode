class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && i - deque.getFirst() > k) {
                deque.removeFirst();
            }

            if(!deque.isEmpty()) {
                nums[i] = Math.max(nums[i], nums[i] + nums[deque.getFirst()]); 
            }
            max = Math.max(nums[i], max);

            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        return max;
    }
}