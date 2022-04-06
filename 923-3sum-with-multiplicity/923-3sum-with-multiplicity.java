class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        long ans = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int T = target - arr[i];
            int j = i + 1, k = arr.length - 1;
            while( j < k){
                if(arr[j] + arr[k] > T) k--;
                else if(arr[j] + arr[k] < T)    j++;
                else if(arr[j] != arr[k]){
                    int l = 1, r = 1;
                    while(j + 1 < k && arr[j] == arr[j+1]){
                        l++;
                        j++;
                    }
                    while(k - 1 > j && arr[k] == arr[k-1]){
                        r++;
                        k--;
                    }
                    ans += l*r;
                    ans %= mod;
                    j++;
                    k--;
                }
                else{
                    ans += (k-j+1)*(k-j)/2;
                    ans %= mod;
                    break;
                }
            }
        }
        return (int)ans;
    }
}