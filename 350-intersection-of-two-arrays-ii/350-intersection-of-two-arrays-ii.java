class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums1.length ; i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        ArrayList<Integer> r = new ArrayList<>();
        for(int i = 0; i < nums2.length ; i++){
            if(map.containsKey(nums2[i])){
                r.add(nums2[i]);
                if(map.get(nums2[i]) == 1)  map.remove(nums2[i]);
                else    map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int[] result = new int[r.size()];
        for(int i = 0; i < r.size() ; i++){
            result[i] = r.get(i);
        }
        return result;
    }
}