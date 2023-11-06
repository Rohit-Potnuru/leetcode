class SeatManager {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public SeatManager(int n) {
        for(int i = 1; i <=n; i++) {
            this.pq.add(i);
        }
    }
    
    public int reserve() {
        return this.pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        this.pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */