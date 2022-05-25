class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> list = new ArrayList();
        for (int[] num : envelopes) {
        int pile = Collections.binarySearch(list, num[1]);
        if (pile < 0) pile = ~pile;
        if (pile == list.size()) {
            list.add(num[1]);
        } else {
            list.set(pile, num[1]);
        }
    }
    return list.size();
    }
}