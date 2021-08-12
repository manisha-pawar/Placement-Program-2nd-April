import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][]cost = new int[n][k];
        
        for(int i=0; i < n;i++) {
            for(int j=0;j < k;j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        
        int mincost = paintHouseKcolors(cost);
        System.out.println(mincost);
    }
    
    public static int paintHouseKcolors(int[][]cost) {
        int n = cost.length;
        int k = cost[0].length;
        
        int[][]dp = new int[n][k];
        int om = Integer.MAX_VALUE;
        int osm = Integer.MAX_VALUE;
        
        for(int i=0; i < n;i++) {
            
            int nm = Integer.MAX_VALUE;
            int nsm = Integer.MAX_VALUE;
            
            for(int j=0; j < k;j++) {
                if(i == 0) {
                    dp[i][j] = cost[i][j];
                }
                else {
                    //try to use min of previous row
                    if(dp[i-1][j] == om) {
                        //you have to use old second min
                        dp[i][j] = osm + cost[i][j];
                    }
                    else {
                        //we can use old min
                        dp[i][j] = om + cost[i][j];
                    }
                }
                
                //maintain current row's min and second
                if(dp[i][j] < nm) {
                    nsm = nm;
                    nm = dp[i][j];
                }
                else if(dp[i][j] < nsm) {
                    nsm = dp[i][j];
                }
            }
            
            om = nm;
            osm = nsm;
            
        }
        
        return om;
    }
     
}