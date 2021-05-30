import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]arr = new int[n];
        
        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        
        int[][]qb = new int[n][tar+1];
        
        // int ans = targetSumSubset_mem(arr,0,tar,qb);
        
        // //0 -> unsolved
        // //1 -> true
        // //2 -> false
        
        // if(ans == 1) {
        //     System.out.println("true");
        // }
        // else {
        //     System.out.println("false");
        // }
        
        boolean ans = targetSumSubset_tab(arr,tar);
        
        System.out.println(ans);
    }
    
    public static boolean targetSumSubset_tab(int[]arr,int target) {
        
        int n  = arr.length;
        boolean[][]dp = new boolean[n][target+1];
        
        for(int i = n-1; i >= 0;i--) {
            for(int ct=0; ct <= target;ct++) {
                if(ct == 0) {
                    dp[i][ct] = true;
                }
                else if(i == n-1) {
                    if(ct == arr[i]) {
                        dp[i][ct] = true;
                    }
                }
                else {
                    boolean exc = dp[i+1][ct]; //arr[i] is excluded in subset
                    boolean inc = false;
                    
                    if(ct-arr[i] >= 0) {
                        inc = dp[i+1][ct-arr[i]]; //arr[i] is included in subset
                    }
                    
                    dp[i][ct] = exc || inc;
                }
            }
        }
        
        return dp[0][target];
        
    }
    
    
    public static int targetSumSubset_mem(int[]arr,int idx,int target,int[][]qb) {
        
        if(idx == arr.length) {
            if(target == 0) {
                return 1;
            }
            else {
                return 2;
            }
        }
        
        if(target == 0) {
            return 1;
        }
        
        if(target < 0) {
            return 2;
        }
        
        if(qb[idx][target] != 0) {
            return qb[idx][target];
        }
        
        int inc = targetSumSubset_mem(arr,idx+1,target-arr[idx],qb);
        
        if(inc == 1) {
            qb[idx][target] = 1;
            return 1;    
        }
        
        int exc = targetSumSubset_mem(arr,idx+1,target,qb);
        
        int myans = (exc == 1) ? 1 : 2;
        qb[idx][target] = myans;
        
        return myans;
    }
    
}