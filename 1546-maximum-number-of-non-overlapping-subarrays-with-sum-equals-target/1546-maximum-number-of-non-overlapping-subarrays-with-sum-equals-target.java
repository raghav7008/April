class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int soFar = -1;
        map.put(0,-1);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - target) && soFar <= map.get(sum-target)){
                count++;
                soFar = i;
            }
            map.put(sum,i);
        }
        return count;
    }
}