class Solution {
    HashMap<Integer,Integer> map = new HashMap();
    public int fib(int n) {
        int res = 0;
        if( n <= 1) return n;
        else if(map.containsKey(n)) return map.get(n);
        else res = fib(n-1) + fib(n-2);
        map.put(n,res);
        return res;
    }
}