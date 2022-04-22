// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean vis[]=new boolean [V];
       ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>> ();
       //doing topological sort
     
       int count=0;
       for(int i=0;i<V;i++){
          for(int j=0;j<V;j++){
             //  for(int j:adj.get(i)){
           if(vis[j]==false && adj.get(i).get(j)==1 ){
               count++;
               dfs(adj,j,vis,V);
           }
           
           }
       }
       return count;
   }
    
   static void dfs(ArrayList<ArrayList<Integer>>adj,int i,boolean vis[],int V){
       vis[i]=true;
      for(int j=0;j<V;j++){
          //for(int j:adj.get(i)){
          if(adj.get(i).get(j)==1 && vis[j]==false)
           dfs(adj,j,vis,V);
      }
       
       
   }
   
};