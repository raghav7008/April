class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        Arrays.fill(result,'a');
        k -= n;
        n--;
        while(k > 0){
            if(k > 25){
                result[n] += 25;
                n--;
                k -= 25;
            }
            else{
                result[n] += k;
                k = 0;
            }
        }
        return String.valueOf(result);
    }
}