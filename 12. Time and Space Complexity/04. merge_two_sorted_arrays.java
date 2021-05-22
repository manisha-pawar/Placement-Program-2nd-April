import java.io.*;
import java.util.*;

public class Main {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        //write your code here
        int len = a.length + b.length;
        int[] merged = new int[len];

        int i = 0; //for first array
        int j = 0; //for second array
        int k = 0; //for merged array

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                merged[k] = a[i];
                i++;
                k++;
            } else {
                merged[k] = b[j];
                j++;
                k++;
            }
        }

        //if some elements are left in 'a'
        while (i < a.length) {
            merged[k] = a[i];
            i++;
            k++;
        }

        //if some elements are left in 'b'
        while (j < b.length) {
            merged[k] = b[j];
            j++;
            k++;
        }

        return merged;

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

}