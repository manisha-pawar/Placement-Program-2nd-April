import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wt[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        // int profit = ZOKnapsack(val,wt,cap);
        int[][] qb = new int[val.length][cap + 1];
        int profit = ZOKSM(val, wt, cap, 0, qb);
        System.out.println(profit);
    }


    public static int ZOKSM(int[] val, int[] wt, int rem_cap, int idx, int[][] qb) {
        if (idx == val.length) {
            return 0;
        }

        if (qb[idx][rem_cap] != 0) {
            return qb[idx][rem_cap];
        }

        int exc = ZOKSM(val, wt, rem_cap, idx + 1, qb);
        int inc = 0;

        if (rem_cap >= wt[idx]) {
            inc = ZOKSM(val, wt, rem_cap - wt[idx], idx + 1, qb) + val[idx];
        }

        int myans = Math.max(exc, inc);
        qb[idx][rem_cap] = myans;

        return myans;
    }



    public static int ZOKnapsack(int[] val, int[] wt, int cap) {
        int[][] dp = new int[val.length][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    //there is only one item
                    if (j >= wt[i]) {
                        dp[i][j] = val[i];
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    //cap is zero
                    dp[i][j] = 0;
                } else {
                    int exc = dp[i - 1][j];
                    int inc = 0;

                    if (j >= wt[i]) {
                        inc = dp[i - 1][j - wt[i]] + val[i];
                    }

                    dp[i][j] = Math.max(exc, inc);
                }
            }
        }

        return dp[val.length - 1][cap];
    }

}