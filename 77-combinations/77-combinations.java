class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList();
        backtrack(1, n, k, temp);
        return result;
    }
    public void backtrack(int start, int end, int size, List<Integer> temp){
        if(temp.size() == size){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if(start > end) return;
        for(int i = start; i <= end; i++){
            temp.add(i);
            backtrack(i+1, end, size, temp);
            temp.remove(temp.size()-1);
        }
    }
}