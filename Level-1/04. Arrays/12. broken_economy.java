import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int key = scn.nextInt();

        ceilAndFloor(arr, key);
    }

    public static void ceilAndFloor(int[] arr, int data) {
        int ceil = -1;
        int floor = -1;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == data) {
                System.out.println(data);
                return;
            } else if (arr[mid] < data) {
                lo = mid + 1;
                floor = arr[mid];
            } else {
                hi = mid - 1;
                ceil = arr[mid];
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }

}