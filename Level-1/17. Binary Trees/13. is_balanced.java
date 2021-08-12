import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }


    //1. using static variable
    static boolean isBal;
    public static int helper(Node node) {
        if (node == null) {
            return 0; //height in terms of node
        }

        int lh = helper(node.left);
        int rh = helper(node.right);

        int bf = Math.abs(lh - rh); //balancing factor

        if (bf > 1) {
            isBal = false;
        }

        return Math.max(lh, rh) + 1;
    }

    public static boolean isBalanced(Node root) {
        isBal = true;

        helper(root);

        return isBal;
    }



    //2. using return type pair
    public static class BalPair {
        int ht;
        boolean isBal;

        BalPair() {

        }

        BalPair(int ht, boolean isBal) {
            this.ht = ht;
            this.isBal = isBal;
        }
    }

    public static BalPair helper(Node node) {
        if (node == null) {
            return new BalPair(0, true);
        }

        BalPair lp = helper(node.left);
        BalPair rp = helper(node.right);

        int bf = Math.abs(lp.ht - rp.ht); //balancing factor
        boolean isBal = lp.isBal && rp.isBal && (bf <= 1);
        int ht = Math.max(lp.ht, rp.ht) + 1;

        return new BalPair(ht, isBal);
    }

    public static boolean isBalanced(Node root) {
        BalPair rp = helper(root);
        return rp.isBal;
    }

    
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        System.out.println(isBalanced(root));

    }

}