class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeat = new HashSet<>();
        for(int i = 0; i + 9 < s.length(); i++){
            String t = s.substring(i, i + 10);
            if(!seen.contains(t))   seen.add(t);
            else    repeat.add(t);
        }
        return new ArrayList<String>(repeat);
    }
}