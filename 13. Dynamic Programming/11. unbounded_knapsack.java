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

        int profit = unboundedKS(val, wt, cap);
        System.out.println(profit);
    }

    public static int unboundedKS(int[] val, int[] wt, int cap) {
        int[] dp = new int[cap + 1];

        dp[0] = 0;

        for (int i = 1; i <= cap; i++) {
            int max = 0;
            for (int j = 0; j < val.length; j++) {

                if (i >= wt[j]) {
                    int rem_cap = i - wt[j];
                    int pr = dp[rem_cap] + val[j];

                    if (pr > max) {
                        max = pr;
                    }
                }
            }

            dp[i] = max;
        }

        return dp[cap];
    }

}