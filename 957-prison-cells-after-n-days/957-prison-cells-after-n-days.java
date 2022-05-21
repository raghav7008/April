class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> set = new HashSet<>();
        boolean is = false;
        int count = 0;
        for(int i = 1; i <= n; i++){
            int[] temp = next(cells);
            if(!set.contains(Arrays.toString(temp))){    
                set.add(Arrays.toString(temp));
                count++;
            }
            else{
                is = true;
                break;
            }
            cells = temp;
        }
        if(is){
            n %= count;
            for(int i = 0; i < n; i++){
                cells = next(cells);
            }
        }
        return cells;
    }
    public int[] next(int[] cells){
        int[] temp = new int[8];
        temp[0] = 0;
        temp[7] = 0;
        for(int i = 1; i < 7; i++){
            temp[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return temp;
    }
}