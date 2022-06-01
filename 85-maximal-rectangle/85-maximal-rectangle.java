class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                mat[i][j] = matrix[i][j] - '0';
            }
        }
        int[] height = new int[matrix[0].length];
        height = mat[0];
        int result = largestRectangle(height);
        for(int i = 1; i < matrix.length; i++){
            resetHeight(mat, height, i);
            result = Math.max(result, largestRectangle(height));
        }
        return result;
    }
    public void resetHeight(int[][] mat, int[] height, int i){
        for(int j = 0; j < mat[0].length; j++){
            if(mat[i][j] == 0)  height[j] = 0;
            else    height[j] += 1;
        }
    }
    public int largestRectangle(int[] heights) {
        Stack<Integer> st = new Stack();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] area = new int[n];
        for(int i = 0; i < n; i++){
            if(st.isEmpty()){
                st.push(i);
                left[i] = 0;
            }
            else if(heights[st.peek()] >= heights[i]){
                while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] = 0;
                    st.push(i);
                }
                else{
                    left[i] = st.peek() + 1;
                    st.push(i);
                }
            }
            else{
                left[i] = st.peek() + 1;
                st.push(i);
            }
        }
        //System.out.println(Arrays.toString(left));
        while(!st.isEmpty())    st.pop();
        for(int i = n - 1; i >= 0; i--){
            if(st.isEmpty()){
                st.push(i);
                right[i] = n-1;
            }
            else if(heights[st.peek()] >= heights[i]){
                while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i] = n-1;
                    st.push(i);
                }
                else{
                    right[i] = st.peek() - 1;
                    st.push(i);
                }
            }
            else{
                right[i] = st.peek() - 1;
                st.push(i);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            area[i] = (right[i] - left[i] + 1) * heights[i];
            max = Math.max(area[i],max);
        }
        return max;
    }
}