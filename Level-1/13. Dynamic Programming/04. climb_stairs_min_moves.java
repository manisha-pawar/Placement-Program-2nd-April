import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]jumps = new int[n];
        
        for(int i=0; i < n;i++) {
            jumps[i] = scn.nextInt();
        }
        
        int[]qb = new int[n+1];
        
        Arrays.fill(qb,-1);
        
        // int mj = CSMM_mem(jumps,0,n,qb);
        int mj = CSMM_tab(jumps);
        
        if(mj == Integer.MAX_VALUE) {
            System.out.println("null");
        }
        else {
            System.out.println(mj);
        }
        
    }
    
    public static int CSMM_tab(int[]jumps) {
        int n = jumps.length;
        int[]dp = new int[n+1];
        
        //dp[i] -> i to n min jumps
        
        dp[n] = 0;
        
        for(int i = n-1; i >= 0;i--) {
            int min = Integer.MAX_VALUE;
            for(int s = 1; s <= jumps[i] && i + s <= n;s++) {
                int ntodmj = dp[i+s];
                
                if(min  > ntodmj) {
                    min = ntodmj;
                }
            }
            
            if(min == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            }
            else {
                dp[i] = min + 1;
            }
        }
        
        return dp[0];
    }
    
    public static int CSMM_mem(int[]jumps,int src,int dest,int[]qb) {
        if(src == dest) {
            return 0;
        }
        
        if(qb[src] != -1) {
            return qb[src];    
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int s=1; s <= jumps[src] && src + s <= jumps.length;s++) {
            int ntodmj = CSMM_mem(jumps,src + s,dest,qb);
            
            if(min  > ntodmj) {
                min= ntodmj;
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            qb[src] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        
        int stodmj = min + 1;
        qb[src] = stodmj;
        
        return stodmj;
        
        
    }

}