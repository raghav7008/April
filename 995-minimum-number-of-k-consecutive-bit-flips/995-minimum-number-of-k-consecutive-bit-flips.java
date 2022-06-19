class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        Queue<Integer> q = new LinkedList();
        
        for(int i = 0; i < len; i++){
            if((nums[i] == 0 && q.size() % 2 == 0) || (nums[i] == 1 && q.size() % 2 == 1)){
                res++;
                if(i + k > len)    return -1;
                q.offer(i + k - 1);
            }
            if(q.size() > 0 && q.peek() == i)   q.remove();
        }
        return res;
    }
}