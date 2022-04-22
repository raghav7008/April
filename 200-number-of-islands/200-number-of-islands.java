class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(Character.compare(grid[i][j], '1') == 0){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if(i - 1 >= 0 && Character.compare(grid[i-1][j], '1') == 0){
            dfs(grid, i - 1, j);
        }
        if(j - 1 >= 0 && Character.compare(grid[i][j-1], '1') == 0){
            dfs(grid, i, j - 1);
        }
        if(i + 1 < grid.length && Character.compare(grid[i+1][j],'1') == 0){
            dfs(grid, i+1, j);
        }
        if(j + 1 < grid[0].length && Character.compare(grid[i][j+1], '1') == 0){
            dfs(grid, i, j+1);
        }
    }
}