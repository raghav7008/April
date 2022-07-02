class Solution { // (m-1 + n-1)!/(m-1)!*(n-1)!
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        long res = 1;
        long j = 1;
        for(long i = m + 1; i <= m + n; i++, j++){
            res *= i;
            res /= j;
        }
        return (int)res;
    }
}