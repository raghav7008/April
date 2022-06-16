class Solution {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];   
        int[] cols = new int[grid[0].length];
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    rows[i]++;
                    cols[j]++;
                    total++;
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && rows[i] == 1 && cols[j] == 1){
                    total--;
                }
            }
        }
        return total;
    }
}