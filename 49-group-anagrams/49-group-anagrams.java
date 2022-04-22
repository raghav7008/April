class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length ; i++){
            String s = strs[i];
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            if(!map.containsKey(Arrays.toString(chArray))){
                List<String> temp = new ArrayList<String>();
                temp.add(s);
                map.put(Arrays.toString(chArray),temp);
            }
            else{
                map.get(Arrays.toString(chArray)).add(s);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            result.add((List<String>)e.getValue());
        }
        return result;
    }
}