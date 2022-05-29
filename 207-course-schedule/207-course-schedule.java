class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i = 0; i < num; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < pre.length; i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        int[] inDegree = new int[num];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < num; i++){
            for(int x : adj.get(i)){
                inDegree[x]++;
            }
        }
        for(int i = 0; i < num; i++){
            if(inDegree[i] == 0)    q.add(i);
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;
            for(int it : adj.get(temp)){
                inDegree[it]--;
                if(inDegree[it] == 0)   q.add(it);
            }
            
        }
        return count == num;
    }
}