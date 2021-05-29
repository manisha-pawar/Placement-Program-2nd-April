import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]jumps = new int[n];
        
        for(int i=0; i < jumps.length;i++) {
            jumps[i] = scn.nextInt();
        }
        
        int[]qb = new int[n+1];
        Arrays.fill(qb,-1);
        
        // int ways = CSVJ_mem(jumps,0,n,qb);
        int ways = CSVJ_tab(jumps);
        
        System.out.println(ways);
    }
    
    public static int CSVJ_tab(int[]jumps) {
        int n = jumps.length;
        int[]dp = new int[n+1];
        
        //dp[i] -> i to n ways
        
        dp[n] = 1;
        
        for(int i = n-1; i >= 0;i--) {
            for(int s=1; s <= jumps[i] && i + s <= n;s++) {
                dp[i] += dp[i + s];
            }
        }
        
        return dp[0];
    }
    
    public static int CSVJ_mem(int[]jumps,int src,int dest,int[]qb) {
        if(src == dest) {
            return 1;
        }
        
        if(src > dest) {
            return 0;    
        }
        
        if(qb[src] != -1) {
            return qb[src];
        }
        
        int stod = 0; //src to dest
        for(int s = 1; s <= jumps[src];s++) {
            int ntod = CSVJ_mem(jumps,src + s,dest,qb); //nbr to dest 
            stod += ntod;
        }
        
        qb[src] = stod;
        
        return stod;
    }

}