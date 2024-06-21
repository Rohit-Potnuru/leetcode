class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> profitPQ = new PriorityQueue<>();

        int n = capital.length;
        int[][] cp = new int[n][2];
        for(int i = 0; i < n; i++) {
            cp[i][0] = capital[i];
            cp[i][1] = profits[i];
        }

        Arrays.sort(cp, new Comparator<int[]>() {
            @Override
            public int compare(int[] cp1, int[] cp2) {
                if(cp1[0] == cp2[0]) {
                    return Integer.compare(cp1[1], cp2[1]);
                }
                return Integer.compare(cp1[0], cp2[0]);
            }
        });

        int curr = 0;
        while(k > 0) {
            while(curr < n && cp[curr][0] <= w) {
                profitPQ.add(-cp[curr][1]);
                curr++;
            }
            if(profitPQ.isEmpty()) {
                break;
            }
            w -= profitPQ.poll();
            k--;
        }
        return w;
    }
}