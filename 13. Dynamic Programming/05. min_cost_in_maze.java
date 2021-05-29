import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][]cost = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        
        int[][]qb = new int[n][m];
        
        //int minCost = mazeMinCost_mem(cost,0,0,n-1,m-1,qb);
        int minCost = mazeMinCost_tab(cost);
        System.out.println(minCost);
    }
    
    public static int mazeMinCost_tab(int[][]cost) {
        int n = cost.length;
        int m = cost[0].length;
        
        int[][]dp = new int[n][m];
        
        //dp[i][j] -> i,j to dest min cost
        
        for(int i = n-1; i >= 0;i--) {
            for(int j = m-1; j >= 0; j--) {
                
                if(i == n-1 && j == m-1) {
                    dp[i][j] = cost[i][j];
                }
                else if(i == n-1) {
                    dp[i][j] = dp[i][j+1] + cost[i][j];
                }
                else if(j == m-1) {
                    dp[i][j] = dp[i+1][j] + cost[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j]) + cost[i][j];
                }
            }
        }
        
        return dp[0][0];
        
        
    }
    
    public static int mazeMinCost_mem(int[][]cost,int sr,int sc,int dr,int dc,int[][]qb) {
        if(sr == dr && sc == dc) {
            return cost[sr][sc];
        }
        
        if(sr > dr || sc > dc) {
            return Integer.MAX_VALUE;
        }
        
        if(qb[sr][sc] != 0) {
            return qb[sr][sc];
        }
        
        int hnc = mazeMinCost_mem(cost,sr,sc + 1,dr,dc,qb); //horizontal nbr to dest min Cost
        int vnc = mazeMinCost_mem(cost,sr + 1,sc,dr,dc,qb); //vertican nbr to dest min cost
        
        int stodmc = Math.min(hnc,vnc) + cost[sr][sc]; //src to dest min cost
        qb[sr][sc] = stodmc;
        
        return stodmc;
    }

}