class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        int max = 0;
        String res = "";
        HashSet<String> set = new HashSet<>();
        for(String t : banned)  set.add(t);
        HashMap<String, Integer> map = new HashMap<>();
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = normalizedStr.split("\\s+");
        for(int i = 0; i < words.length; i++){
            String temp = words[i];
            if(!set.contains(temp)){
                map.put(temp, map.getOrDefault(temp,0)+1);
                if(map.get(temp) > max){
                    max = map.get(temp);
                    res = temp;
                }
            }
        }
        return res;
    }
}