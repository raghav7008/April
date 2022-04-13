class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int[][] arr = new int[n][n];
        int rowB = 0, rowE = n-1;
        int colB = 0, colE = n-1;
        while(rowB <= rowE && colB <= colE){
            for(int i = colB; i <= colE; i++){
                arr[rowB][i] = count;
                count++;
            }
            rowB++;
            for(int i = rowB; i <= rowE; i++){
                arr[i][colE] = count;
                count++;
            }
            colE--;
            for(int i = colE; i >= colB; i--){
                arr[rowE][i] = count;
                count++;
            }
            rowE--;
            for(int i = rowE; i >= rowB; i--){
                arr[i][colB] = count;
                count++;
            }
            colB++;
        }
        return arr;
    }
}