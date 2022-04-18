class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0; j < grid[i].length ; j++){
                if(grid[i][j] == 1){
                    m = Math.max(m , dfs(grid , i , j));
                }
            }
        }
        return m;
    }
    
    public int dfs(int [][] grid , int r , int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        int count = 1;
        count += dfs(grid , r+1 , c);
        count += dfs(grid , r , c + 1);
        count += dfs(grid , r - 1 , c);
        count += dfs(grid , r , c - 1);
        
        return count;
    }
}