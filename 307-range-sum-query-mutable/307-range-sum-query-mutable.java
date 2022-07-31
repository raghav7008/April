class NumArray {
    int[] seg;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[nums.length * 4];
        build(0, nums.length - 1, nums, 0);
    }
    public int build(int l, int r, int[] nums, int node){
        if(l == r)  return seg[node] = nums[l];
        int mid = (l + r)/2;
        int leftSum = build(l, mid, nums, 2 * node + 1);
        int rightSum = build(mid + 1, r, nums, 2 * node + 2);
        return seg[node] = leftSum + rightSum;
    }
    public void update(int index, int val) {
        update(index, val, 0, n-1, 0);
    }
    public int update(int index, int newValue, int ss, int se, int node) {
        int leftSum, rightSum;
        int middle;

        if (index < ss || index > se) return seg[node];
        if (ss == se) return seg[node] = newValue;

        middle = (ss + se) / 2;
        leftSum = update(index, newValue, ss, middle, 2 * node + 1);
        rightSum = update(index, newValue, middle+1, se, 2 * node + 2);
        return seg[node] = leftSum + rightSum;
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, n - 1, 0);
    }
    public int sumRange(int left, int right, int ss, int se, int node) {
        int leftSum, rightSum;
        int middle;

        if (right < ss || left > se) return 0;
        if (left <= ss && se <= right) return seg[node];

        middle = (ss + se) / 2;
        leftSum = sumRange(left, right, ss, middle, 2 * node + 1);
        rightSum = sumRange(left, right, middle+1, se, 2 * node + 2);

        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */