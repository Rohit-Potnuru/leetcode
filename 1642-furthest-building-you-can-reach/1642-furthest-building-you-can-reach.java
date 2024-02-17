class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 1; i < n; i++) {
            int d = heights[i] - heights[i - 1];
            if(d > 0) {
                priorityQueue.add(d);
            }
            while(priorityQueue.size() > ladders) {
                bricks -= priorityQueue.poll();
            }
            if(bricks < 0) {
                return i - 1;
            }
        }
        return n - 1;
    }
}