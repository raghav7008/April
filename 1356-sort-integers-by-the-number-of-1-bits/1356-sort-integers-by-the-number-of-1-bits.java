class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for(int i = 0; i < arr.length ; i++)    a[i] = arr[i];
        Arrays.sort(a, Comparator.comparing(i -> Integer.bitCount(i) * 10000 + i));
        for(int i = 0; i < arr.length ; i++)    arr[i] = a[i];
        return arr;
    }
}