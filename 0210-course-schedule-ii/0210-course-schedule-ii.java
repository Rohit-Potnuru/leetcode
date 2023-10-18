class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Boolean[] visited = new Boolean[numCourses];
        ArrayList<Integer>[] adjMatrix = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adjMatrix[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int[] prerequisite: prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adjMatrix[u].add(v);
            inDegree[v]++;
        }

        int[] courseOrder = new int[numCourses];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                visited[i] = true;
                courseOrder[count++] = i;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v: adjMatrix[u]) {
                if(--inDegree[v] == 0) {
                    visited[v] = true;
                    courseOrder[count++] = v;
                    q.add(v);
                }
            }
        }

        if(count == numCourses) 
            return courseOrder;
        return new int[]{};
    }
}