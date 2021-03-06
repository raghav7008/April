class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];
        leftMax[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        rightMin[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1],arr[i]);
        }
        int chunks = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(leftMax[i] <= rightMin[i + 1])    chunks++;
        }
        return chunks + 1;
    }
}