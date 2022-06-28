class Solution {
    public String longestNiceSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray())   set.add(c);
        for(int i = 0; i < s.length(); i++){
            if(set.contains(Character.toLowerCase(s.charAt(i))) && set.contains(Character.toUpperCase(s.charAt(i))))  continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}