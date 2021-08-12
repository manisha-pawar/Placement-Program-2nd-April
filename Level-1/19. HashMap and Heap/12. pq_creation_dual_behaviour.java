import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList < Integer > data;
        boolean min_pq;

        public PriorityQueue(boolean type) {
            data = new ArrayList < > ();
            min_pq = type;
        }
        
        //+ve -> v1 has higher priority 
        //-ve -> v2 has lower priority
        
        private int priority(int v1,int v2) {
            if(min_pq == true) {
                //smaller value has higher priority
                return v2-v1;
            }
            else {
                //larger value has higher priority
                return v1-v2;
            }
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

            if(priority(data.get(ci),data.get(pi)) > 0) {
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

            if (lci < data.size() && priority(data.get(lci),data.get(hpi)) > 0) {
                hpi = lci;
            }

            if (rci < data.size() && priority(data.get(rci),data.get(hpi)) > 0) {
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
        PriorityQueue pq = new PriorityQueue(false); //true -> min pq, false -> max pq
        
        pq.add(5);
        pq.add(9);
        pq.add(13);
        pq.add(16);
        pq.add(7);
        
        while(pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
        
        System.out.println();

       
    }
}