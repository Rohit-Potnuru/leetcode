class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] -  b[1];
                }
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> roomPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        });

        int[] rooms = new int[n], temp;
        for(int i = 0; i < n; i++) roomPQ.add(i);
        for(int[] meeting: meetings) {
            while(!pq.isEmpty() && pq.peek()[0] <= meeting[0]) {
                roomPQ.add(pq.poll()[1]);
            }

            if(!roomPQ.isEmpty()) {
                int roomIndex = roomPQ.poll();
                rooms[roomIndex]++;
                temp = new int[]{meeting[1], roomIndex};
                pq.add(temp);
            }
            else {
                temp = pq.poll();
                rooms[temp[1]]++;
                temp[0] += meeting[1] - meeting[0];
                pq.add(temp);
            }
        }

        int max = 0, maxRoom = 0;
        for(int i = 0; i < n; i++) {
            if(max < rooms[i]) {
                maxRoom = i;
                max = rooms[i];
            }
        }
        return maxRoom;
    }
}


