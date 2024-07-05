class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degreeMap = new int[n];
        for(int[] road: roads) {
            int u = road[0];
            int v = road[1];
            degreeMap[u]++;
            degreeMap[v]++;
        }

        long sum = 0;
        Arrays.sort(degreeMap);
        for(int i = 0; i < n; i++) {
            sum += degreeMap[i] * (i + 1);
        } 
        return sum;
    }
}