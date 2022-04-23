class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        int n = nums.length;
        Arrays.fill(arr,-1);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < 2 * n ; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                arr[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return arr;
    }
}