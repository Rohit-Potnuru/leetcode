class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Boolean[] visited = new Boolean[numCourses];
        ArrayList<Integer>[] adjMatrix = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adjMatrix[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int[] prerequisite: prerequisites) {
            int v = prerequisite[0];
            int u = prerequisite[1];
            inDegree[v]++;
            adjMatrix[u].add(v);
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()) {
            int u = q.poll();
            for(Integer v: adjMatrix[u]) {
                if(visited[v]) {
                    return false;
                }
                if(--inDegree[v] == 0) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }
}