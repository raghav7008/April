class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((b,a) -> Integer.compare((a[0] * a[0]) + (a[1] * a[1]), (b[0] * b[0]) + (b[1] * b[1])));
        for(int i = 0 ; i < points.length ; i++){
            pq.add(points[i]);
            if(pq.size() > k)   pq.poll();
        }
//         while(!pq.isEmpty()){
            
//         }
        int[][] arr = new int[k][2];
        while(!pq.isEmpty()){
            arr[--k] = pq.poll();
        }
        return arr;
    }
}