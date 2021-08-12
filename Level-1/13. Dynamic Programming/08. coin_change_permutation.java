import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[]coins = new int[n];
        
        for(int i=0; i < n;i++) {
            coins[i] =scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        // int ways = CCP(coins,amt);
        
        int ways = CCP_tab(coins,amt);
        
        System.out.println(ways);
    }
    
    
    public static int CCP_tab(int[]coins,int amt) {
        int[]dp = new int[amt+1];
        
        //dp[i] -> ways to pay 'i' amount
        
        dp[0] = 1;
        
        for(int i = 1; i <= amt;i++) {
            for(int j = 0; j < coins.length;j++) {
                int rem_amt = i - coins[j];
                
                if(rem_amt >= 0) {
                    dp[i] += dp[rem_amt];
                }
            }
        }
        
        return dp[amt];
        
    }
    
    public static int CCP(int[]coins,int amt) {
        if(amt == 0) {
            return 1;
        }
        
        int ways = 0;
        
        for(int i=0; i < coins.length;i++) {
            int rem_amt = amt-coins[i];
            
            if(rem_amt >= 0) {
                int temp = CCP(coins,rem_amt);
                ways += temp;
            }
        }
        
        return ways;
    }
}