import java.util.*;

public class Main {

    //method 1 -> brute force method
    public static int maxSum1(int[] arr) {
        // write your code here.

        int mss = Integer.MIN_VALUE;

        for (int st = 0; st < arr.length; st++) {
            for (int et = st; et < arr.length; et++) {
                //create subarray sum
                int ss = 0;
                for (int k = st; k <= et; k++) {
                    ss += arr[k];
                }
                if (ss > mss) {
                    mss = ss;
                }
            }
        }

        return mss;
    }

    //method 2 -> using kadane's algo
    public static int maxSum2(int[] arr) {
        int cs = arr[0];
        int ms = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (cs < 0) {
                //new start
                cs = arr[i];
            } else {
                //continue
                cs += arr[i];
            }

            if (cs > ms) {
                ms = cs;
            }
        }

        return ms;
    }


    //print maximum sum subarray using kadane's
    public static int maxSum(int[] arr) {
        int cs = arr[0];
        int ms = arr[0];

        int cst = 0;
        int cet = 0;

        int mst = 0;
        int met = 0;

        for (int i = 1; i < arr.length; i++) {
            if (cs < 0) {
                //new start
                cs = arr[i];
                cst = i;
                cet = i;
            } else {
                //continue
                cs += arr[i];
                cet = i;
            }

            if (cs > ms) {
                ms = cs;
                mst = cst;
                met = cet;
            }
        }

        for (int k = mst; k <= met; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();

        return ms;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSum2(arr));

    }

}