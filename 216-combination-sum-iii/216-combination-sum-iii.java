class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> curr = new ArrayList();
        for(int i = 1; i <= 9; i++){
            if(i <= n){
                curr.add(i);
                dfs(list, curr, i, k, n, i);
                curr.remove(curr.size() - 1);
            }
        }
        return list;
    }
    public void dfs(List<List<Integer>> list, List<Integer> curr, int start, int k, int n, int sum){
        if(sum == n && curr.size() == k){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start + 1; i <= 9; i++){
            if(sum + i <= n){
                curr.add(i);
                dfs(list, curr, i, k, n, sum + i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}