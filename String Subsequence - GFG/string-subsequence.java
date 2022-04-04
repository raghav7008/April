// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(String s1, String s2) { 
        int[][] dp = new int[s1.length() + 1][s2.length()+1];
        for(int i = 0 ; i <= s1.length() ; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= s1.length() ; i++){
            for(int j = 1; j <= s2.length() ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[s1.length()][s2.length()];
    }
}