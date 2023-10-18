class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        //for Creating adjacent matrix
        int src, dest;
        int[] timeTaken = new int[n];
        ArrayList<Integer>[] adjMatrix = new ArrayList[n];
        int[] inDegree = new int[n];
        //initialization
        for(int i = 0; i < n; i++) adjMatrix[i] = new ArrayList<>();

        //generating adj matrix
        for(int[] relation: relations) {
            src = relation[0] - 1;
            dest = relation[1] - 1;
            inDegree[dest]++;
            adjMatrix[src].add(dest);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                timeTaken[i] = time[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            src = q.poll();
            for(Integer d: adjMatrix[src]) {
                timeTaken[d] = Math.max(timeTaken[d], timeTaken[src] + time[d]);
                if(--inDegree[d] == 0) {
                    q.add(d);
                }
            }
        }

        int maxTime = 0;
        for(int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, timeTaken[i]);
        }
        return maxTime;
    }
}