class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : tasks)  map.put(x, map.getOrDefault(x,0)+1);
        int count = 0;
        for(int x : map.values()){
            if(x == 1)  return -1;
            else if(x % 3 == 0) count += x/3;
            else{
                while(true){
                    if(x == 1)  return -1;
                    else if(x % 3 == 0){
                        count += x/3;
                        break;
                    }
                    else{
                        count++;
                        x -= 2;
                    }
                }
            }
        }
        return count;
    }
}