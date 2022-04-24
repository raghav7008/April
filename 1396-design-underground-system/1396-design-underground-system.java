class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> checkIn = new HashMap<>();
    HashMap<String, Pair<Integer, Integer>> checkOut = new HashMap<>();
    public UndergroundSystem() {
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> check = checkIn.get(id);
        String route = check.getKey() + "-" + stationName;
        Pair<Integer, Integer> check2 = checkOut.getOrDefault(route, new Pair<>(0,0));
        int total = t - check.getValue();
        checkOut.put(route, new Pair<>(check2.getKey() + total, check2.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        Pair<Integer,Integer> check = checkOut.get(route);
        return (double)check.getKey()/check.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */