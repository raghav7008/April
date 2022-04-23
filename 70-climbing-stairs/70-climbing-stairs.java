class Solution {
    HashMap<Integer,Integer> map = new HashMap();
    public int climbStairs(int n) {
        int res = 0;
        if(n < 3)   return n;
        else if(map.containsKey(n))  return map.get(n);
        else{ 
            res = climbStairs(n-1) + climbStairs(n-2);
            
        }
        map.put(n,res);
        return res;
    }
}