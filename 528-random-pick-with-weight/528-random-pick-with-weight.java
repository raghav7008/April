class Solution {
    int[] arr;
    Random r = new Random();
    int max = 0;
    public Solution(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];
        for(int i = 1; i < w.length; i++){
            arr[i] = arr[i-1] + w[i];
        }
        max = arr[arr.length - 1];
    }
    
    public int pickIndex() {
        int rnd = r.nextInt(max) + 1;
        int temp = Arrays.binarySearch(arr, rnd);
        if(temp < 0)    return -temp-1;
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */