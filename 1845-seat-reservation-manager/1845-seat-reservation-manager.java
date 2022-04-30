class SeatManager {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    HashMap<Integer,Boolean> map = new HashMap<>();
    public SeatManager(int n) {
        for(int i = 1; i <= n; i++){
            pq.offer(i);
        }
    }
    
    public int reserve() {
        int temp = pq.poll();
        map.put(temp,true);
        return temp;
    }
    
    public void unreserve(int seatNumber) {
        map.remove(seatNumber);
        pq.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */