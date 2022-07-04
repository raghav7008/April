class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        long x = 2;
        List<Long> list = new ArrayList<Long>();
        if(finalSum % 2 != 0)   return list;
        while(true){
            if(finalSum >= x){
                list.add(x);
                finalSum -= x;
                x += 2;
            }
            else{
                list.add(finalSum + list.remove(list.size()-1));
                break;
            }
        }
        return list;
    }
}