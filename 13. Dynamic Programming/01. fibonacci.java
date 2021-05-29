import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] qb = new int[n + 1];
        Arrays.fill(qb, -1);

        // int nth = fib_mem(n,qb);
        int nth = fib_tab(n);
        System.out.println(nth);
    }

    public static int fib_tab(int n) {
        //1. create storage
        int[] dp = new int[n + 1];

        //2. assign meaning to your storage, dp[i] -> fib(i)

        //3. travel and solve from smallest to largest
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    public static int fib_mem(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (qb[n] != -1) {
            return qb[n];
        }

        int fibn = fib_mem(n - 1, qb) + fib_mem(n - 2, qb);
        qb[n] = fibn;

        return fibn;
    }

}