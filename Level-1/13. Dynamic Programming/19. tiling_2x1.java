import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        System.out.println(Tiling(n));
    }
    
    public static int Tiling(int n) {
        int[]dp = new int[n+1];
        
        //dp[i] -> ways to tile up 2*i area
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2; i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}