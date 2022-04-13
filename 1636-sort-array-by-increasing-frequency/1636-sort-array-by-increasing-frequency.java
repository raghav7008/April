class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0]-b[0] : b[1]-a[1]);
        for(int i = 0; i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            pq.add(new int[] {m.getValue(), m.getKey()});
        }
        int k = 0;
        while(pq.size() > 0){
            int[] temp = pq.poll();
            for(int i = 0; i < temp[0]; i++){
                nums[k] = temp[1];
                //System.out.println(nums[k]);
                k++;
            }
        }
        return nums;
    }
}