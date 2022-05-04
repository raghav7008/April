class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if(map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0 && nums[i] != k - nums[i]){
                count++;
                map.put(k-nums[i], map.get(k-nums[i])-1);
                map.put(nums[i], map.get(nums[i])-1);
            }
            else if(map.containsKey(k-nums[i]) && nums[i] == k - nums[i] && map.get(nums[i]) > 1){
                count++;
                map.put(nums[i], map.get(nums[i]) - 2);
            }
        }
        System.out.println(map);
        return count;
    }
}