class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int num : nums) {
        int pile = Collections.binarySearch(list, num);
        if (pile < 0) pile = ~pile;
        if (pile == list.size()) {
            list.add(num);
        } else {
            list.set(pile, num);
        }
    }
    return list.size();
    }
}