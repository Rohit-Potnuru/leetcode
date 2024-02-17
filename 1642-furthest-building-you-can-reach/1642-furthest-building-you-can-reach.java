class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 1; i < n; i++) {
            int d = heights[i] - heights[i - 1];
            if(d < 0) continue;
            bricks -= d;
            priorityQueue.add(-d);
            if(bricks < 0) {
                bricks -= priorityQueue.poll();
                if (ladders > 0) ladders--;
                else return i - 1;
            }
        }
        return n - 1;
    }
}