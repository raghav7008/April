class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int A = 0, B = 0, C = 0;
        int size = a + b + c;
        for(int i = 0; i < size; i++){
            if((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0)){
                sb.append('a');
                A++;
                a--;
                B = 0;
                C = 0;
            }
            else if((b >= a && b >= c && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)){
                sb.append('b');
                B++;
                b--;
                A = 0;
                C = 0;
            }
            else if((c >= b && c >= a && C != 2) || (B == 2 && c > 0) || (A == 2 && c > 0)){
                sb.append('c');
                C++;
                c--;
                B = 0;
                A = 0;
            }
        }
        return sb.toString();
    }
}