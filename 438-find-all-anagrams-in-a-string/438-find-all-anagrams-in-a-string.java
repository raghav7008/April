class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0 || s.length() < p.length())   return list;
        int[] ch = new int[26];
        for(int i = 0; i < p.length() ; i++){
            ch[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = 0;
        int len = p.length();
        int diff = len;
        for(end = 0; end < len ; end++){
            ch[s.charAt(end)-'a']--;
            if(ch[s.charAt(end)-'a'] >= 0)  diff--;
        }
        if(diff == 0)   list.add(0);
        while(end < s.length()){
            char temp = s.charAt(start);
            if(ch[temp-'a'] >= 0)   diff++;
            ch[temp-'a']++;
            start++;
            temp = s.charAt(end);
            ch[temp-'a']--;
            if(ch[temp-'a'] >= 0)   diff--;
            if(diff == 0)   list.add(start);
            end++;
        }
        return list;
    }
}