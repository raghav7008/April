class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length ; i++){
            map.put(words[i], map.getOrDefault(words[i],0) + 1);
        }
        for(Map.Entry<String,Integer> m : map.entrySet()){
            String t = m.getKey();
            int i = 0 , j = 0;
            while( i < s.length() && j < t.length()){
                if(t.charAt(j) == s.charAt(i))  j++;
                i++;
            }
            if(j == t.length()) count += m.getValue();  
        }
        return count;
    }
}