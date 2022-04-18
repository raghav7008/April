// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Node implements Comparable<Node>{
    int v, w;
    Node(int _v, int _w){
        v = _v;
        w = _w;
    }
    public int getV(){
        return v;
    }
    public int getWeight(){
        return w;
    }
    
    public int compareTo(Node n1){
        return this.w - n1.w;
    }
}
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        int[] dist = new int[v];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        pq.add(new Node(s,0));
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            for(ArrayList<Integer> it : adj.get(temp.v)){
                if(dist[temp.v] + it.get(1) < dist[it.get(0)]){
                    dist[it.get(0)] = dist[temp.v] + it.get(1);
                    pq.add(new Node(it.get(0),dist[it.get(0)]));
                }
            }
        }
        return dist;
    }
}

