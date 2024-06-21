class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalPQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] cp1, int[] cp2) {
                if(cp1[0] == cp2[0]) {
                    return Integer.compare(cp1[1], cp2[1]);
                }
                return Integer.compare(cp1[0], cp2[0]);
            }
        });
        
        PriorityQueue<Integer> profitPQ = new PriorityQueue<>();

        int n = capital.length;
        for(int i = 0; i < n; i++) {
            capitalPQ.add(new int[]{capital[i], profits[i]});
        }

        while(k > 0) {
            while(!capitalPQ.isEmpty() && capitalPQ.peek()[0] <= w) {
                profitPQ.add(-capitalPQ.poll()[1]);
            }
            if(profitPQ.isEmpty()) {
                break;
            }
            int temp = profitPQ.poll();
            System.out.println(temp);
            w -= temp;
            k--;
        }
        return w;
    }
}