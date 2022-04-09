class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] b = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int freq = frequencyMap.get(key);
		if (b[freq] == null) {
			b[freq] = new ArrayList<>();
		}
		b[freq].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = b.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (b[pos] != null) {
			res.addAll(b[pos]);
		}
	}
	int[] arr = new int[res.size()];
        for(int i = 0; i < res.size() ; i++)    arr[i] = res.get(i);
        return arr;
    }
}