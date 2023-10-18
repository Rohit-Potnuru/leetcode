class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] timeTaken = new int[n];
        for(int i = 0; i < n; i++) {
            timeTaken[i] = time[i];
        }

        //for Creating adjacent matrix
        int src, dest;
        ArrayList<Integer>[] adjMatrix = new ArrayList[n];
        int[] inDegree = new int[n];
        //initialization
        for(int i = 0; i < n; i++) {
            adjMatrix[i] = new ArrayList<>();
            inDegree[i] = 0;
        }

        //generating adj matrix
        for(int[] relation: relations) {
            src = relation[0] - 1;
            dest = relation[1] - 1;
            inDegree[dest]++;
            adjMatrix[src].add(dest);
        }

        int count = n;
        while(count > 0) {
            count = 0;
            for(int i = 0; i < n; i++) {
                if(inDegree[i] == 0) {
                    inDegree[i]--;
                    for(Integer d: adjMatrix[i]) {
                        timeTaken[d] = Math.max(timeTaken[d], timeTaken[i] + time[d]);
                        inDegree[d]--;
                    }
                    count++;
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
/*
1
2    5
3 4

1 0
2 0
3 0
4 1
5 4
*/