class SeatManager {
    PriorityQueue<Integer> pq;
    int count;
    public SeatManager(int n) {
        this.count = 1;
        this.pq = new PriorityQueue<Integer>();
    }
    
    public int reserve() {
        if(pq.size() == 0)
            return this.count++;
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