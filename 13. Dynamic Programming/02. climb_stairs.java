import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]qb = new int[n+1];
        
        Arrays.fill(qb,-1);
        
        // int ways = climbStairs_mem(n,qb);
        
        int ways = climbStairs_tab(n);
        System.out.println(ways);
    }
    
    public static int climbStairs_tab(int n) {
        int[]dp = new int[n+1];
        
        //dp[i] -> i to 0 ways
        dp[0] = 1;
        
        for(int i=1; i <= n;i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            }
            else if(i == 2) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        
        return dp[n];
    }
    
    public static int climbStairs_mem(int n,int[]qb) {
        if(n == 0) {
            return 1;    
        }
        
        if(qb[n] != -1) {
            return qb[n];    
        }
        
        int ways = 0;
        
        if(n-1 >= 0) {
            ways += climbStairs_mem(n-1,qb);
        }
        
        if(n-2 >= 0) {
            ways += climbStairs_mem(n-2,qb);
        }
        
        if(n-3 >= 0) {
            ways += climbStairs_mem(n-3,qb);
        }
        
        qb[n] = ways;
        return ways;
    }

}