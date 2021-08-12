import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // code
        int maxArea = largestAreaHistogram(a);
        System.out.println(maxArea);
    }

    public static int largestAreaHistogram(int[] ht) {
        int[] nsl = nextSmallerLeft(ht);
        int[] nsr = nextSmallerRight(ht);

        int maxArea = 0;

        for (int i = 0; i < ht.length; i++) {
            int h = ht[i];
            int w = nsr[i] - nsl[i] - 1;
            int area = h * w;

            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static int[] nextSmallerLeft(int[] arr) {
        int[] nsl = new int[arr.length];
        Stack < Integer > st = new Stack < > ();
        nsl[0] = -1;
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        return nsl;
    }

    public static int[] nextSmallerRight(int[] arr) {
        int[] nsr = new int[arr.length];
        Stack < Integer > st = new Stack < > ();
        nsr[arr.length - 1] = arr.length;
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = st.peek();
            }

            st.push(i);
        }

        return nsr;
    }

}