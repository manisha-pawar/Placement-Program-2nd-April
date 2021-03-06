import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList < Integer > data;

        public PriorityQueue() {
            data = new ArrayList < > ();
        }

        public void add(int val) {
            data.add(val); // o(1)
            upheapify(data.size() - 1); //o(log n)
        }

        private void upheapify(int ci) {
            if (ci == 0) {
                return;
            }

            int pi = (ci - 1) / 2;

            if (data.get(ci) < data.get(pi)) {
                //child has more priority than parent
                swap(ci, pi);
                upheapify(pi);
            }

        }

        private void swap(int i, int j) {
            int i_val = data.get(i);
            int j_val = data.get(j);

            data.set(i, j_val);
            data.set(j, i_val);
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                int li = data.size() - 1;
                swap(0, li);

                int val = data.remove(li); //o(1)

                downheapify(0); //o(log n)
                return val;
            }
        }

        private void downheapify(int pi) {
            int hpi = pi;

            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if (lci < data.size() && data.get(lci) < data.get(hpi)) {
                hpi = lci;
            }

            if (rci < data.size() && data.get(rci) < data.get(hpi)) {
                hpi = rci;
            }


            if (pi != hpi) {
                swap(pi, hpi);
                downheapify(hpi);
            }


        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                return data.get(0);
            }
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}