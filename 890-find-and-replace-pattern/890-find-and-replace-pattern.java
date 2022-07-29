class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> str = new ArrayList();
        for(String temp : words){
            if(check(temp,pattern)) str.add(temp);
        }
        return str;
    }
    public boolean check(String s, String p){
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);
            if(!m1.containsKey(c1))     m1.put(c1,c2);   
            if(!m2.containsKey(c2))     m2.put(c2,c1);   
            if(m1.get(c1) != c2 || m2.get(c2) != c1)    return false;
        }
        return true;
    }
}