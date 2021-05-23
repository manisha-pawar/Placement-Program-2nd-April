import java.io.*;
import java.util.*;

public class Main {

    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int size = max - min + 1;
        int[] freq = new int[size];

        //fill freq array
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - min]++;
        }

        //prefix sum array
        int[] ps = new int[freq.length];
        ps[0] = freq[0];

        for (int i = 1; i < freq.length; i++) {
            ps[i] = ps[i - 1] + freq[i]; //0 to i ka sum
        }

        //create ans array
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = ps[arr[i] - min] - 1;
            ans[idx] = arr[i];
            ps[arr[i] - min]--;
        }


        //copy answer array to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

}