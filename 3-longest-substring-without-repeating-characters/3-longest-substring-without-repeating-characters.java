class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap();
        int max = 0;
        int i = 0;
        int j = 0;
        for(j = 0; j < s.length() ; j++){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),j);
            }
            else{
                i = Math.max(i,map.get(s.charAt(j)) + 1);
                map.put(s.charAt(j),j);
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}