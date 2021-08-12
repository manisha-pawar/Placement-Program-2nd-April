import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        System.out.println(friendsPairing(n));
    }
    
    public static int friendsPairing(int n) {
        int[]dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i <= n;i++) {
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        
        return dp[n];
    }

}