class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
            int temp = sum % k;
            if(temp == 0 && i >= 1)  return true;   
            if(!map.containsKey(temp)){
                map.put(temp,i);
            }
            else{
                int a = map.get(temp);
                if(i - a > 1)   return true;
            }
        }
        return false;
    }
}