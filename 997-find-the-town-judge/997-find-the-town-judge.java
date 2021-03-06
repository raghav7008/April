class Solution {
    public int findJudge(int N, int[][] trust) {
        // HashSet<Integer> set = new HashSet<>();
        // for(int i = 1; i <= n; i++) set.add(i);
        // for(int i = 0; i < trust.length; i++)   set.remove(trust[i][0]);
        // if(set.size() == 0)  return -1;
        // int num = 0;
        // for(int x : set)    num = x;
        // int count = 0;
        // for(int i = 0; i < trust.length; i++){
        //     if(trust[i][1] == num)  count++;
        // }
        // if(count == n-1)  return num;
        // return -1;
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}