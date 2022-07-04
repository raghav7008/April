class StockPrice {
    TreeMap<Integer, HashSet<Integer>> vals = new TreeMap<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int prev = map.get(timestamp);
            HashSet<Integer> temp = vals.get(prev);
            temp.remove(timestamp);
            if(temp.isEmpty()){
                vals.remove(prev);
            }
        }
        vals.putIfAbsent(price, new HashSet<Integer>());
        vals.get(price).add(timestamp);
        map.put(timestamp, price);
    }
    
    public int current() {
        return map.lastEntry().getValue();
    }
    
    public int maximum() {
        return vals.lastKey();
    }
    
    public int minimum() {
        return vals.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */