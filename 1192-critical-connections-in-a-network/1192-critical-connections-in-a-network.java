class Solution {
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n ; i++)    adj.add(new ArrayList<Integer>());
        for(List<Integer> t : connections){
            adj.get(t.get(0)).add(t.get(1));
            adj.get(t.get(1)).add(t.get(0));
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int timer = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, -1, vis, tin, low, adj, timer);
            }
        }
        return list;
    }
    public void dfs(int node, int parent, int[] vis, int[] tin, int[] low, List<List<Integer>> adj, int timer){
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        for(int it : adj.get(node)){
            if(it == parent)    continue;
            if(vis[it] == 0){
                dfs(it, node, vis, tin, low, adj, timer);
                low[node] = Math.min(low[node],low[it]);
                if(low[it] > tin[node]){
                    List<Integer> temp = new ArrayList();
                    temp.add(it);
                    temp.add(node);
                    list.add(temp);
                }
            }
            else    low[node] = Math.min(low[node],tin[it]);
        }
    }
}