class Solution {
    boolean pTrue = false, aTrue = false;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                pTrue = false;
                aTrue = false;
                boolean[][] vis = new boolean[heights.length][heights[0].length];
                //vis[i][j] = true;
                dfs(heights, i, j, heights[i][j], vis);
                if(pTrue && aTrue){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }
    public void dfs(int[][] heights, int row, int col, int val, boolean[][] vis){
        if(col == 0 || row == 0){
            pTrue = true;
            //return;
        }
        if(col == heights[0].length - 1 || row == heights.length - 1){
            aTrue = true;
            //return;
        }
        if(!vis[row][col]){
        vis[row][col] = true;
        //System.out.println(heights[row][col] + " " + row + " " + col);
        if(row - 1 >= 0 && heights[row-1][col] <= heights[row][col])  dfs(heights, row - 1, col, val, vis);
        if(col - 1 >= 0 && heights[row][col-1] <= heights[row][col])  dfs(heights, row, col - 1, val, vis);
        if(row + 1 < heights.length && heights[row+1][col] <= heights[row][col])  dfs(heights, row + 1, col, val, vis);
        if(col + 1 < heights[0].length && heights[row][col+1] <= heights[row][col])  dfs(heights, row, col + 1, val, vis);
        }
    }
}