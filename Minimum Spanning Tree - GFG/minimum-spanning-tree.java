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
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        //int[] keys = new int[v];
        boolean[] mst = new boolean[v];
        //int[] parent = new int[v];
        for(int i = 0; i < v; i++){
            //keys[i] = Integer.MAX_VALUE;
            mst[i] = false;
            //parent[i] = -1;
        }
        //keys[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        int ans = 0;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(mst[temp.v]) continue;
            mst[temp.v] = true;
            ans += temp.w;
            for(ArrayList<Integer> it : adj.get(temp.v)){
                if(!mst[it.get(0)]){
                    // parent[it.get(0)] = temp.v;
                    // keys[it.get(0)] = it.get(1);
                    pq.add(new Node(it.get(0), it.get(1)));
                }
            }
            
        }
        //for(int x : keys)   ans += x;
        return ans;
    }
    static class Node implements Comparable<Node>{
        int v, w;
        Node(int _v, int _w){
            v = _v;
            w = _w;
        }
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }
}
