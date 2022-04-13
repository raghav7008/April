class Solution {
    public String frequencySort(String s) {
        // HashMap<Character,Integer> map = new HashMap<>();
        // PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>();
        // for(int i = 0; i < s.length() ; i++){
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        // }
        // for(Map.Entry<Character,Integer> m : map.entrySet()){
        //     pq.add(new Pair((int)m.getValue(),(char)m.getKey()));
        // }
        // String res = "";
        // while(pq.size() > 0){
        //     Pair<Integer,Character> p = pq.poll();
        //     for(int i = 0; i < p.getKey(); i++){
        //         res += p.getValue();
        //     }
        // }
        // return res;
        Map<Character, Integer> map = new HashMap();        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }      
        
        PriorityQueue <Character> pq = new PriorityQueue((a,b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();       
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }       
        return sb.toString();
    }
}