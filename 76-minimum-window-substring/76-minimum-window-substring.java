class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
        if(map.containsKey(c)){
            map.put(c,map.get(c)+1);
        }else{
            map.put(c,1);
        }
    }
        int count = 0, minLen = m + 1, left = 0, minLeft = 0;
        for(int i = 0; i < m; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
            if(map.get(s.charAt(i)) >= 0)   count++;
            }
            while(count == n){
                if(i-left+1 < minLen){
                    minLen = i-left+1;
                    minLeft = left;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) > 0){
                        count--;
                    }
                }
                left++;
            }
            
        }
        if(minLen > s.length()) return "";
        return s.substring(minLeft,minLeft+minLen);
    }
}