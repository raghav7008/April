class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 0)  return 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        boolean[] vis = new boolean[points.length];
        int minEdges = points.length - 1;
        int n = points.length;
        for(int i = 1; i < n; i++){
            int dist = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
            pq.add(new Edge(0,i,dist));
        }
        vis[0] = true;
        int cost = 0;
        while(!pq.isEmpty() && minEdges > 0){
            int p1 = pq.peek().p1;
            int p2 = pq.peek().p2;
            int dist = pq.poll().cost;
            if(!vis[p2]){
                cost += dist;
                vis[p2] = true;
                for(int i = 0; i < n; i++){
                    if(!vis[i]){int temp = Math.abs(points[p2][0] - points[i][0]) + Math.abs(points[p2][1] - points[i][1]);
                    pq.add(new Edge(p2,i,temp));}
                }
                minEdges--;
            }
            
        }
        return cost;
    }
}
class Edge{
    int p1, p2, cost;
    Edge(int p1, int p2, int cost){
        this.p1 = p1;
        this.p2 = p2;
        this.cost = cost;
    }
}