class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegree = new int[n];
        List<Integer>[] adjMap = new ArrayList[n];
        HashSet<Integer>[] set = new HashSet[n];
        for(int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
            adjMap[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            inDegree[edge[1]]++;
            adjMap[edge[0]].add(edge[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int src = q.poll();
            for (int dst : adjMap[src]) {
                set[dst].add(src);
                set[dst].addAll(set[src]);
                inDegree[dst]--;
                if (inDegree[dst] == 0) {
                    q.add(dst);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>(set[i]);
            Collections.sort(temp);
            ans.add(temp);
        }
        return ans;
    }
}