import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        System.out.println(Tiling(n,m));
    }
    
    public static int Tiling(int n,int m) {
        int[]dp = new int[n+1];
        
        //dp[i] -> i*m area ans
        
        for(int i=1; i <= n;i++) {
            if(i < m) {
                dp[i] = 1;
            }
            else if(i == m) {
                dp[i] = 2;
            }
            else {
                dp[i] = dp[i-m] + dp[i-1];
            }
        }
        
        return dp[n];
    }
}