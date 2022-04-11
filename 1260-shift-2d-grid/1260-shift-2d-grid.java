class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while(k > 0){
        int[] arr = new int[grid.length];
        for(int i = 0; i < grid.length ; i++){
            arr[i] = grid[i][grid[0].length-1];
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = grid[0].length-1; j >= 1 ; j--){
                grid[i][j] = grid[i][j-1]; 
            }
        }
        grid[0][0] = arr[arr.length - 1];
        for(int i = 1; i < arr.length ; i++){
            grid[i][0] = arr[i-1];
        }
        k--;
        }
        // for(int i = 0; i < grid.length ; i++)   System.out.println(Arrays.toString(grid[i]));
        List<List<Integer>> result = new ArrayList();
        for(int i = 0 ; i < grid.length ; i++){
            List<Integer> temp = new ArrayList();
            for(int j = 0; j < grid[0].length; j++){
                temp.add(grid[i][j]);
            }
            result.add(temp);
        }
        return result;
    }
}