class Solution {
    public int triangularSum(int[] nums) {
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i = 0; i < nums.length ; i++){
        //     list.add(nums[i]);
        // }
        // //System.out.println(list.toString());
        // while(true){
        //     ArrayList<Integer> temp = new ArrayList<>();
        //     if(list.size() == 1)    return list.get(0);
        //     for(int i = 0; i < list.size() - 1; i++){
        //         temp.add((list.get(i) + list.get(i + 1))%10);
        //     }
        //     list = temp;
        // }
        int n= nums.length;
    while(n>1){
        for(int i=0;i+1<n;i++) nums[i] = (nums[i]+nums[i+1])%10;
        n--;
    }
    return nums[0];
    }
}