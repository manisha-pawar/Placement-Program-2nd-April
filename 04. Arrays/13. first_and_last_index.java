import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int fi = firstIndex(arr, data);
        int li = lastIndex(arr, data);

        System.out.println(fi);
        System.out.println(li);
    }

    public static int firstIndex(int[] arr, int data) {
        int fi = -1;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == data) {
                fi = mid;
                //continue searching in left area
                hi = mid - 1;
            } else if (arr[mid] < data) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return fi;
    }


    public static int lastIndex(int[] arr, int data) {
        int li = -1;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == data) {
                li = mid;
                //continue searching in right area
                lo = mid + 1;
            } else if (arr[mid] < data) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return li;
    }
}