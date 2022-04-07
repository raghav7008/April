class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for(int i = 0; i < stones.length ; i++){
            pq.add(stones[i]);
        }
        while(pq.size() > 1){
            if(pq.size() > 1){
                int first = pq.poll();
                int second = pq.poll();
                pq.add(first-second);
            }
        }
        return pq.peek();
    }
}