class MedianFinder {
    PriorityQueue<Integer> first = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> second = new PriorityQueue<>();
    boolean even = true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(!even){
            first.offer(num);
            second.offer(first.poll());
        }
        else{
            second.offer(num);
            first.offer(second.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (second.peek() + first.peek())/2.0;
        }
        else return first.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */