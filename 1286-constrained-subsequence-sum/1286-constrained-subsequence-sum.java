class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];  // this will order the queue in descending order
            }
        });

        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            while(!pq.isEmpty() && i - pq.peek() > k) {
                pq.remove();
            }

            if(!pq.isEmpty()) {
                nums[i] = Math.max(nums[i], nums[i] + nums[pq.peek()]); 
            }
            max = Math.max(nums[i], max);
            pq.add(i);
        }
        return max;
    }
}