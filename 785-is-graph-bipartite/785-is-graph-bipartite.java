class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1 && !dfs(graph, color, 0, i))  return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph, int[] color, int c, int node){
        if(color[node] != -1)   return color[node] == c;
        color[node] = c;
        for(int x : graph[node]){
                if(!dfs(graph, color, 1 - c, x))    return false;
        }
        return true;
    }
}