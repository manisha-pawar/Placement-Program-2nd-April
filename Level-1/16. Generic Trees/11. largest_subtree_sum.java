import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }


    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }



    //method 1 : static variables
    static int lss; //largest subtree sum
    static Node lssn; //largest subtree sum node

    public static void largestSubtreeSum(Node node) {
        lss = Integer.MIN_VALUE;
        lssn = null;

        subtreeSum(node);

        System.out.println(lssn.data + "@" + lss);
    }

    public static int subtreeSum(Node node) {
        int ss = 0;

        for (Node child: node.children) {
            int css = subtreeSum(child);
            ss += css;
        }

        ss += node.data;

        if (ss > lss) {
            lss = ss;
            lssn = node;
        }

        return ss;
    }




    //method 2 : creating class object instead of static variables
    public static class Pair {
        int lss;
        Node lssn;
    }

    public static void largestSubtreeSum(Node node) {
        Pair gp = new Pair(); //global pair
        gp.lss = Integer.MIN_VALUE;
        gp.lssn = null;

        subtreeSum(node, gp);

        System.out.println(gp.lssn.data + "@" + gp.lss);
    }

    public static int subtreeSum(Node node, Pair gp) {
        int ss = 0;

        for (Node child: node.children) {
            int css = subtreeSum(child, gp);
            ss += css;
        }

        ss += node.data;

        if (ss > gp.lss) {
            gp.lss = ss;
            gp.lssn = node;
        }

        return ss;
    }



    //method 3 : return every needed thing from childs (return type -> pair)
    public static class Pair {
        int ss;
        int lss;
        Node lssn;

        Pair() {

        }

        Pair(int ss, int lss, Node lssn) {
            this.ss = ss;
            this.lss = lss;
            this.lssn = lssn;
        }
    }

    public static Pair LSS(Node node) {

        int ss = 0;
        Pair bcp = new Pair(0, Integer.MIN_VALUE, null); //best child pair

        for (Node child: node.children) {
            Pair cp = LSS(child);

            ss += cp.ss;

            if (cp.lss > bcp.lss) {
                bcp.lss = cp.lss;
                bcp.lssn = cp.lssn;
            }
        }

        ss += node.data;

        Pair np = new Pair();

        np.ss = ss;

        if (np.ss < bcp.lss) {
            np.lss = bcp.lss;
            np.lssn = bcp.lssn;
        } else {
            np.lss = ss;
            np.lssn = node;
        }

        return np;

    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}