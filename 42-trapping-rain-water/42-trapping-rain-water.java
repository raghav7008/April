class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int n = height.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            max = Math.max(max,height[i]);
            left[i] = max;
        }
        System.out.println(Arrays.toString(left));
        max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0 ; i--){
            max = Math.max(max,height[i]);
            right[i] = max;
        }
        System.out.println(Arrays.toString(right));
        int water = 0;
        for(int i = 0; i < n ; i++){
            int temp = Math.min(left[i],right[i]);
            water += temp - height[i];
        }
        return water;
    }
}