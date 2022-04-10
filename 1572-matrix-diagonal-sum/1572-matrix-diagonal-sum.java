class Solution {
    public int diagonalSum(int[][] mat) {
        int pSum = 0;
        int nSum = 0;
        for(int i = 0; i < mat.length ; i++){
            for(int j = 0; j < mat[0].length ; j++){
                if(i == j)  pSum += mat[i][j];
            }
        }
        int i = 0;
        int j = mat.length - 1;
        while(i < mat.length && j >= 0){
            if(i != j)  nSum += mat[i][j];
            i++;
            j--;
        }
        return pSum + nSum;
    }
}