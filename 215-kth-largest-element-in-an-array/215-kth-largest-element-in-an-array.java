class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : nums)   pq.offer(x);
        while(pq.size() > k)   pq.poll();
        return pq.peek();
    }
}