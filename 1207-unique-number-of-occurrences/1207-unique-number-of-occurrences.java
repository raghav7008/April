class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            count.put(a, count.getOrDefault(a,0) + 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int freq : count.values()) {
            if (!seen.add(freq)) {
                return false;
            }
        }
        return true;
    }
}