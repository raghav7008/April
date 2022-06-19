class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int x : machines)   sum += x;
        if(sum % machines.length != 0)    return -1;
        int req = sum / machines.length;
        int max = 0;
        sum = 0;
        for(int i = 0; i < machines.length; i++){
            sum += machines[i];
            max = Math.max(max,Math.abs(sum - (i+1)*req));
            max = Math.max(max, machines[i] - req);
        }
        return max;
    }
}