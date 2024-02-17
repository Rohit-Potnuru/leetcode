class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int sum = 0, pqSum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 1; i < n; i++) {
            if(heights[i] > heights[i - 1]) {
                pqSum += heights[i] - heights[i - 1];
                priorityQueue.add(heights[i] - heights[i - 1]);
            }
            while(priorityQueue.size() > ladders) {
                pqSum -= priorityQueue.peek();
                sum += priorityQueue.poll();
            }
            if(sum > bricks) {
                return i - 1;
            }
        }
        return n - 1;
    }
}