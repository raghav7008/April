class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int x : nums)   set.add(x);
        int max = 0;
        int curr = 0, currMax = 0;
        for(int x : nums){
            if(set.contains(x-1))   continue;
            else{
                curr = x;
                currMax = 1;
            }
            while(set.contains(curr + 1)){
                curr += 1;
                currMax += 1;
            }
            max = Math.max(currMax, max);
        }
        return max;
    }
}