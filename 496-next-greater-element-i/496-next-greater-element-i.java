class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length ; i++){
            if(stack.isEmpty()) stack.push(nums2[i]);
            else if(stack.peek() > nums2[i])    stack.push(nums2[i]);
            else{
                while(!stack.isEmpty() && stack.peek() < nums2[i]){
                    int temp = stack.pop();
                    map.put(temp,nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length ; i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}