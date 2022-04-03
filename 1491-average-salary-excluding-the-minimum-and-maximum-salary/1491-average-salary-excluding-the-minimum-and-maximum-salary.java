class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < salary.length ; i++){
            min = Math.min(min,salary[i]);
            max = Math.max(max,salary[i]);
        }
        int count = 0;
        double sum = 0;
        for(int i = 0; i < salary.length ; i++){
            if(salary[i] != min && salary[i] != max){
                count++;
                sum += salary[i];
            }
        }
        return sum/count;
    }
}