class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            area = Math.min(height[start],height[end]) * (end - start);
            max = Math.max(max,area);
            if(height[start] < height[end]) start++;
            else    end--;
        }
        return max;
    }
}