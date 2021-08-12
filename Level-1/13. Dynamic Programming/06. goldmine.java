import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][]gold = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                gold[i][j] = scn.nextInt();
            }
        }
        
        // int[][]qb = new int[n][m];
        
        // int max = 0;
        
        // for(int i=0; i < n;i++) {
        //     int ans = goldmine_mem(gold,i,0,qb);
            
        //     if(ans > max) {
        //         max = ans;
        //     }
        // }
        
        System.out.println(goldmine_tab(gold));
    }
    
    public static int goldmine_tab(int[][]gold) {
        int n = gold.length;
        int m = gold[0].length;
        
        int[][]dp = new int[n][m];
        
        for(int j = m-1; j >= 0;j--) {
            for(int i = 0; i < n;i++) {
                if(j == m-1) {
                    dp[i][j] = gold[i][j];
                }
                else if(i == 0){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + gold[i][j];
                }
                else if(i == n-1) {
                    dp[i][j] =Math.max(dp[i][j+1],dp[i-1][j+1]) + gold[i][j];
                }
                else {
                    dp[i][j] = Math.max(Math.max(dp[i][j+1],dp[i-1][j+1]),dp[i+1][j+1]) + gold[i][j];
                }
            }
        }
        
        int max = 0;
        for(int i=0; i < n;i++) {
            if(dp[i][0] >  max) {
                max = dp[i][0];
            }
        }
        
        return max;
        
    }
    
    public static int goldmine_mem(int[][]gold,int sr,int sc,int[][]qb) {
        if(sr < 0 || sr >= gold.length) {
            return 0;
        }
        
        if(sc == gold[0].length-1) {
            return gold[sr][sc];
        }
        
        if(qb[sr][sc] != 0) {
            return qb[sr][sc];
        }
        
        int c1 = goldmine_mem(gold,sr-1,sc+1,qb);
        int c2 = goldmine_mem(gold,sr,sc+1,qb);
        int c3 = goldmine_mem(gold,sr+1,sc+1,qb);
        
        int myans = Math.max(Math.max(c1,c2),c3) + gold[sr][sc];
        qb[sr][sc] = myans;
        
        return myans;
    }
    

}