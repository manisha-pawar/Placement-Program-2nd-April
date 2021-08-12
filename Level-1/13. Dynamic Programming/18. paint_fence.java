import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        System.out.println(paintFence(n,k));
    }
    
    public static int paintFence(int n,int k) {
        int[][]dp = new int[2][n+1];
        
        if(n == 1) {
            return k;
        }
        
        for(int j=2; j <= n;j++) {
            if(j == 2) {
                dp[0][j] = k;  //valid number of ways to paint j fences such that last two fences have same color
                dp[1][j] = k*(k-1); //valid number of ways to paint j fences such that last two fences have different color
            }
            else {
                dp[0][j] = dp[1][j-1];
                dp[1][j] = (dp[0][j-1] + dp[1][j-1])*(k-1);
            }
        }
        
        return dp[0][n] + dp[1][n];
    }
}