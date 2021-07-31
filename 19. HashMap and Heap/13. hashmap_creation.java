import java.io.*;
import java.util.*;

public class Main {

    public static class HashMap < K, V > {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList < HMNode > [] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList < > ();
            }
        }

        public void put(K key, V value) throws Exception {
            int bi = getBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                //addition
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            } else {
                //updation
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (size) * 1.0 / (buckets.length);

            if (lambda > 2) {
                //there is a need to rehash
                rehash();
            }
        }

        private void rehash() throws Exception {
            LinkedList < HMNode > [] oldBuckets = buckets;
            initbuckets(oldBuckets.length * 2);
            size = 0;

            for (int b = 0; b < oldBuckets.length; b++) {
                LinkedList < HMNode > list = oldBuckets[b];

                for (HMNode node: list) {
                    K key = node.key;
                    V value = node.value;

                    put(key, value);
                }
            }

        }

        private int findWithinBucket(K key, int bi) {
            LinkedList < HMNode > list = buckets[bi];

            for (int i = 0; i < list.size(); i++) {
                HMNode node = list.get(i);
                if ((node.key).equals(key) == true) {
                    return i;
                }
            }

            return -1;
        }

        private int getBucketIndex(K key) {
            int hc = key.hashCode();

            int bi = (Math.abs(hc)) % buckets.length;

            return bi;
        }

        public V get(K key) throws Exception {
            int bi = getBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                return null;
            } else {
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = getBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) throws Exception {
            int bi = getBucketIndex(key);
            int di = findWithinBucket(key, bi);

            if (di == -1) {
                return null;
            } else {
                HMNode node = buckets[bi].get(di);
                buckets[bi].remove(di);

                size--;

                return node.value;
            }
        }

        public ArrayList < K > keyset() throws Exception {
            ArrayList < K > ks = new ArrayList < > ();

            for (int b = 0; b < buckets.length; b++) {
                LinkedList < HMNode > list = buckets[b];

                for (HMNode node: list) {
                    ks.add(node.key);
                }
            }

            return ks;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node: buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap < String, Integer > map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}