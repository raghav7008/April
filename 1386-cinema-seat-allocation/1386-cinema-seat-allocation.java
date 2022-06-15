class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int result = 0;
        Map<Integer, List<Integer>> rowToSeatRes = new HashMap<>();
        
        for(int[] row : reservedSeats) {
            if(rowToSeatRes.containsKey(row[0])) {
                rowToSeatRes.get(row[0]).add(row[1]);
            } else {
                rowToSeatRes.put(row[0], new ArrayList<Integer>(Arrays.asList(row[1])));
            }
        }

        result = (n - rowToSeatRes.size()) * 2;
        
       for(List<Integer> res : rowToSeatRes.values()) { 
            boolean flag = false;
            if(!res.contains(2) &&
              !res.contains(3) &&
              !res.contains(4) &&
              !res.contains(5)) {
                result++;
                flag = true;
            }
            if(!res.contains(6) &&
              !res.contains(7) &&
              !res.contains(8) &&
              !res.contains(9)) {
                result++;
                flag = true;
            }
            if(!flag) {
                if(!res.contains(4) &&
                   !res.contains(5) &&
                   !res.contains(6) &&
                   !res.contains(7))
                result++;
            }
        }
        
        return result;
    }
}