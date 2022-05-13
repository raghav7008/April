class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0)    return list;
        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == n1)   c1++;
            else if(nums[i] == n2)  c2++;
            else if(c1 == 0){
                n1 = nums[i];
                c1 = 1;
            }
            else if(c2 == 0){
                n2 = nums[i];
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == n1)   c1++;
            else if(nums[i] == n2)   c2++;
        }
        if(c1 > nums.length/3)   list.add(n1);
        if(c2 > nums.length/3)  list.add(n2);
        return list;
    }
}