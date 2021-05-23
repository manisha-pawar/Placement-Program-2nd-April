import java.io.*;
import java.util.*;

public class Main {

    public static void radixSort(int[] arr) {
        // write code here  
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int pow = 1;

        while (max > 0) {
            //use count sort here
            countSort(arr, pow);
            pow = pow * 10;
            max = max / 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        //write your code here
        int[] freq = new int[10]; //0 to 9 digits

        //fill freq array
        for (int i = 0; i < arr.length; i++) {
            freq[(arr[i] / exp) % 10]++;
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
            int idx = ps[(arr[i] / exp) % 10] - 1;
            ans[idx] = arr[i];
            ps[(arr[i] / exp) % 10]--;
        }


        //copy answer array to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }


        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}