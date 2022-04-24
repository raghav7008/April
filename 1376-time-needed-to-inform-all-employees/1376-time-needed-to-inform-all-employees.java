class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++)  adj.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++)  if(manager[i] != -1)    adj.get(manager[i]).add(i);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        int ans = 0;
        while(!q.isEmpty()){
            int[] top = q.poll();
            int curr = top[0], cumulative = top[1];
            ans = Math.max(cumulative, ans);
            for (int v : adj.get(curr)) q.offer(new int[]{v, cumulative + informTime[curr]});
        }
        return ans;
    }
}