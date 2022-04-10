class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < ops.length ; i++){
            if(ops[i].equals("C")){
                list.remove(list.size()-1);
            }
            else if(ops[i].equals("D")){
                list.add(list.get(list.size()-1)*2);
            }
            else if(ops[i].equals("+")){
                list.add(list.get(list.size()-1) + list.get(list.size()-2));
            }
            else{
                list.add(Integer.valueOf(ops[i]));
            }
        }
        int sum = 0;
        for(int x : list)   sum += x;
        return sum;
    }
}