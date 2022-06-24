class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> t1 = new ArrayList<>();
        for(int i = 1; i <= 9; i++) t1.add(i);
        for(int i = 2; i <= n; i++){
            List<Integer> t2 = new ArrayList<>();
            for(int x : t1){
                int y = x % 10;
                if(y + k < 10){
                    t2.add(x * 10 + y + k);
                }
                if(k > 0 && y - k >= 0){
                    t2.add(x * 10 + y - k);
                }
            }
            t1 = t2;
        }
        int[] res = new int[t1.size()];
        for(int i = 0; i < t1.size(); i++)  res[i] = t1.get(i);
        return res;
    }
}