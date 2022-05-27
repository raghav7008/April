class Solution {
    public int numberOfSteps(int num) {
        if(num == 0)    return 0;
        int count = 0;
        while(num > 0){
            int a = num & 1;
            if(a == 1){
                num >>= 1;
                count += 2;
            }
            else{
                num >>= 1;
                count++;
            }
        }
        return count-1;
    }
}