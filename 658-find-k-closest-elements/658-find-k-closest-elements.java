class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList();
        int lo = 0;
        int hi = arr.length - 1;
        while(hi - lo >= k){
            if(Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x))   lo++;
            else hi--;
        }
        for(int i = lo; i <= hi; i++){
            list.add(arr[i]);
        }
        return list;
    }
}