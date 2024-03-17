class Solution {
    class The_Comparator implements Comparator<int[]> {
        public int compare(int[] i1, int[] i2) {
            return i1[0] - i2[0];
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new The_Comparator());
        pq.add(newInterval);
        for(int[] interval: intervals) {
            pq.add(interval);
        }

        ArrayList<int[]> ans = new ArrayList<>();
        int n = -1;
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if(n >= 0 && Math.max(temp[0], ans.get(n)[0]) <= Math.min(temp[1], ans.get(n)[1])) {
                ans.get(n)[1] = Math.max(temp[1], ans.get(n)[1]);
            } 
            else {
                ans.add(temp);
                n++;
            }
        }
        return ans.toArray(new int[n + 1][]);
    }
}