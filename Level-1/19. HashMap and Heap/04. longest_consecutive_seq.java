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

        longestConsecutiveSeq(arr);
    }

    public static void longestConsecutiveSeq(int[] arr) {
        HashMap < Integer, Boolean > map = new HashMap < > ();

        //assume each element can be a seq start
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) == false) {
                map.put(arr[i], true);
            }
        }

        //determine actual seq start
        for (int key: map.keySet()) {
            int ele = key;

            if (map.containsKey(ele - 1) == true) {
                map.put(ele, false);
            }
        }

        //find the longest consecutive seq out of all consective seq
        int st = -1;
        int mlen = 0;

        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            int len = 1;

            if (map.containsKey(ele) == true && map.get(ele) == true) {
                while (map.containsKey(ele + len) == true) {
                    len++;
                }

                if (len > mlen) {
                    mlen = len;
                    st = ele;
                }

                map.remove(ele);
            }

        }

        for (int k = st; k < st + mlen; k++) {
            System.out.println(k);
        }
    }

}