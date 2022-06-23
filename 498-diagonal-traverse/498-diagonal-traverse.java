class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int r = 0, c = 0, m = mat.length, n = mat[0].length;
        for(int i = 0; i < result.length; i++){
            result[i] = mat[r][c];
            if((r + c) % 2 == 0){
                if(c == n - 1)  r++;
                else if(r == 0) c++;
                else{
                    r--;
                    c++;
                }
            }
            else{
                if(r == m - 1)  c++;
                else if(c == 0) r++;
                else{
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}