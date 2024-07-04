class Solution {
    private int find(int u, int[] arr) {
        while(arr[u] >= 0) {
            u = arr[u];
        }
        return u;
    }

    private int union(int u, int v, int[] arr)  {
        int xu = find(u, arr);
        int xv = find(v, arr);
        if(xu != xv) {
            if(arr[xu] > arr[xv]) {
                arr[xv] += arr[xu];
                arr[xu] = xv;
            }
            else {
                arr[xu] += arr[xv];
                arr[xv] = xu;
            }
            return 1;
        }
        else {
            return 0;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] arr = new int[n];
        for(int j = 0; j < n; j++) {
            arr[j] = -1;
        }

        int[] res = new int[2];
        int result = 0;
        for(int[] edge: edges) {
            int type = edge[0] - 1, u = edge[1] - 1, v = edge[2] - 1;
            if(type == 2) {
                if(union(u, v, arr) == 1) {                
                    res[0]++;
                    res[1]++;
                }
                else {
                    result++;
                }
            }
        }

        int[] temp;
        for(int i = 0; i < 2; i++) {
            temp = Arrays.copyOf(arr, n);
            for(int[] edge: edges) {
                int type = edge[0] - 1, u = edge[1] - 1, v = edge[2] - 1;
                if(type == i) {
                    if(union(u, v, temp) == 1) {                
                        res[i]++;
                    }
                    else {
                        result++;
                    }
                }
            }
        }



        if(res[0] == res[1] && res[1] == n - 1) {
            return result;
        }
        return -1;
    }
}