// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // boolean[] vis = new boolean[v];
        // boolean[] dfsvis = new boolean[v];
        
        // for(int i = 0; i < v; i++){
        //     if(vis[i] == false){
        //         if(dfs(vis, dfsvis, adj, i))    return true;
        //     }
        // }
        // return false;
        int[] in = new int[v];
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < adj.size(); i++){
            for(int x : adj.get(i)){
                in[x]++;
            }
        }
        for(int i = 0; i < v; i++)  if(in[i] == 0)  q.add(i);
        while(!q.isEmpty()){
            int size = q.size();
            int temp = q.remove();
            count++;
            for(int it : adj.get(temp)){
                in[it]--;
                if(in[it] == 0) q.add(it);
            }
        }
        //System.out.println(count);
        return !(count == v);
    }
    
    public boolean dfs(boolean[] vis, boolean[] dfsvis, ArrayList<ArrayList<Integer>> adj, int i){
        vis[i] = true;
        dfsvis[i] = true;
        
        for(int x : adj.get(i)){
            if(vis[x] == false){
                if(dfs(vis, dfsvis, adj, x))    return true;
            }
            if(dfsvis[x])   return true;
        }
        dfsvis[i] = false;
        return false;
    }
}