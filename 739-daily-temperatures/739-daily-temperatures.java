class Solution {
    class Pair{
        int temp,ind;
        Pair(int _temp, int _ind){
            temp = _temp;
            ind = _ind;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<Pair>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(st.isEmpty())    st.push(new Pair(temperatures[i],i));
            else{
                if(st.peek().temp >= temperatures[i])    st.push(new Pair(temperatures[i],i));
                else{
                    while(!st.isEmpty() && st.peek().temp < temperatures[i]){
                        Pair t = st.pop();
                        ans[t.ind] = i - t.ind;
                    }
                    st.push(new Pair(temperatures[i],i));
                }
            }
        }
        return ans;
    }
}