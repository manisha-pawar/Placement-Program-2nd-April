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
        int k = Integer.parseInt(br.readLine());

        // code
        slidingWindowMax(a, k);
    }

    public static void slidingWindowMax(int[] arr, int k) {
        int[] ngr = nextGreaterRight(arr);
        int n = arr.length;
        int j = 0;

        for (int i = 0; i <= n - k; i++) {
            if (j < i) {
                j = i;
            }

            //i+k-1 is i'th window's ending point
            while (ngr[j] < i + k) {
                //next greater lies within window
                j = ngr[j];
            }

            System.out.println(arr[j]);
        }
    }

    public static int[] nextGreaterRight(int[] arr) {
        int n = arr.length;
        int[] ngr = new int[n];
        ngr[n - 1] = n;
        Stack < Integer > st = new Stack < > ();
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                ngr[i] = n;
            } else {
                ngr[i] = st.peek();
            }

            st.push(i);
        }

        return ngr;
    }

}