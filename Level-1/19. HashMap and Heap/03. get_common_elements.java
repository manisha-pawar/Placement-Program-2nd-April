import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        //getCommonElements1(a1,a2);

    }



    //get common elements 1
    public static void getCommonElements1(int[] a1, int[] a2) {
        HashSet < Integer > hs = new HashSet < > ();

        for (int val: a1) {
            if (hs.contains(val) == false) {
                hs.add(val);
            }
        }

        for (int val: a2) {
            if (hs.contains(val) == true) {
                System.out.println(val);
                hs.remove(val);
            }
        }
    }



    //get common elements 2
    public static void getCommonElements2(int[] a1, int[] a2) {
        HashMap < Integer, Integer > map = new HashMap < > ();

        //fill this map using 1st array
        for (int ele: a1) {
            if (map.containsKey(ele) == false) {
                map.put(ele, 1);
            } else {
                int nf = map.get(ele) + 1;
                map.put(ele, nf);
            }
        }

        //travel second and print your ans
        for (int ele: a2) {
            if (map.containsKey(ele) == true && map.get(ele) > 0) {
                System.out.println(ele);
                int nf = map.get(ele) - 1;
                map.put(ele, nf);
            }
        }
    }

}