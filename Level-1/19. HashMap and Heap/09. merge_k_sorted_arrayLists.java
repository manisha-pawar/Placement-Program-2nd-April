import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable < Pair > {
        int val;
        int li; //list index
        int di; //data index

        Pair() {

        }

        Pair(int val, int li, int di) {
            this.val = val;
            this.li = li;
            this.di = di;
        }

        //this < o -> -ve
        //this > o -> +ve
        //this == o -> 0
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static ArrayList < Integer > mergeKSortedLists(ArrayList < ArrayList < Integer >> lists) {
        ArrayList < Integer > ans = new ArrayList < > ();

        PriorityQueue < Pair > pq = new PriorityQueue < > (); //smaller value has higher priority

        for (int i = 0; i < lists.size(); i++) {
            int li = i;
            int di = 0;
            int val = lists.get(i).get(di);

            pq.add(new Pair(val, li, di));
        }


        while (pq.size() > 0) {
            Pair rem = pq.remove();

            ans.add(rem.val);

            int nli = rem.li;
            int ndi = rem.di + 1;

            if (ndi < lists.get(nli).size()) {
                int val = lists.get(nli).get(ndi);
                pq.add(new Pair(val, nli, ndi));
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList < ArrayList < Integer >> lists = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ArrayList < Integer > list = new ArrayList < > ();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList < Integer > mlist = mergeKSortedLists(lists);
        for (int val: mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}