class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjMap = new ArrayList<>();
        int[] cost = new int[n];
        for(int i = 0; i < n; i++) {
            adjMap.add(new ArrayList<>());
            cost[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < flights.length; i++) {
            adjMap.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});

        k++;
        while(queue.size() > 0 && k >= 0) {
            int c = queue.size();
            while(c > 0) {
                int[] curr = queue.poll();
                cost[curr[0]] = Math.min(cost[curr[0]], curr[1]);
                for(int i = 0; i < adjMap.get(curr[0]).size(); i++) {
                    int node = adjMap.get(curr[0]).get(i)[0];
                    int price = adjMap.get(curr[0]).get(i)[1];

                    if(cost[node] <= curr[1] + price) continue;
                    queue.add(new int[]{node, curr[1] + price});
                }
                c--;
            } 
            k--;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1: cost[dst];
    }
}