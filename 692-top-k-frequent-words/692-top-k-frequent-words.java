class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for(Map.Entry<String, Integer> m : map.entrySet()){
            pq.offer(m);
            if(pq.size() > k)   pq.poll();
        }
        while(!pq.isEmpty())
            res.add(0, pq.poll().getKey());
        
        return res;
    }
}