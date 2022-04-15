// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Node{
    int first;
    int second;
    public Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // boolean[] vis = new boolean[v];
        // for(int i = 0; i < v; i++){
        //     if(!vis[i]){
        //         if(dfs(i, -1, vis, adj))    return true;
        //     }
        // }
        // return false;
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                Queue<Node> q = new LinkedList();
                q.add(new Node(i,-1));
                vis[i] = true;
                while(!q.isEmpty()){
                    int curr = q.peek().first;
                    int par = q.peek().second;
                    vis[curr] = true;
                    q.remove();
                    for(int it: adj.get(curr)){
                        if(!vis[it]){
                            q.add(new Node(it,curr));
                        }
                        else if(par != it)  return true;
                    }
                }
            }
        }
        return false;
        
    }
    // public boolean dfs(int curr, int par, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
    //     vis[curr] = true;
    //     for(int it: adj.get(curr)){
    //         if(!vis[it]){
    //             if(dfs(it, curr, vis, adj)) return true;
    //         }
    //         else if(par != it)  return true;
    //     }
    //     return false;
    // }
}