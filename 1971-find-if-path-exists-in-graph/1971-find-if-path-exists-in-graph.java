class Solution {
    public int find(int pos, int[] nodes) {
        while(nodes[pos] >= 0) {
            pos = nodes[pos];
        }
        return pos;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] nodes = new int[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = -1;
        }

        for(int[] edge: edges) {

            // Find
            int src = find(edge[0], nodes);
            int dst = find(edge[1], nodes);
            if(src != dst) {
                nodes[src] += nodes[dst];
                nodes[dst] = src;
            }
        }

        return find(source, nodes) == find(destination, nodes);
    }
}