import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static class Node {
        int data;
        ArrayList < Node > children;

        Node() {

        }

        Node(int data) {
            this.data = data;
            this.children = new ArrayList < > ();
        }
    }

    public static Node construct(int[] data) {
        Stack < Node > st = new Stack < > ();
        Node root = null;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == -1) {
                st.pop();
            } else {
                Node nn = new Node(data[i]);

                if (st.size() > 0) {
                    Node par = st.peek();
                    par.children.add(nn);
                } else {
                    root = nn;
                }

                st.push(nn);
            }
        }

        return root;
    }

    public static void display(Node node) {
        //node & its children
        System.out.print(node.data + " -> ");
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            System.out.print(child.data + " ");
        }
        System.out.println(".");

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            display(child);
        }
    }



    //size of tree
    public static int size(Node node) {
        int ts = 0; //total size

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int cfs = size(child); //child family size

            ts += cfs;
        }

        return ts + 1;
    }



    //max of tree
    public static int max(Node node) {
        int omax = Integer.MIN_VALUE;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            int cfm = max(child); //child family max

            if (cfm > omax) {
                omax = cfm;
            }
        }

        return Math.max(node.data, omax);

    }



    //height of tree
    public static int height(Node node) {
        int mcht = -1; //max child height

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            int htc = height(child); //height of child

            if (htc > mcht) {
                mcht = htc;
            }
        }

        return mcht + 1;
    }



    //traversals
    public static void traversals(Node node) {
        //node pre
        System.out.println("Node Pre " + node.data);

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            //edge pre
            System.out.println("Edge Pre " + node.data + "--" + child.data);

            traversals(child); //edge

            //edge post
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        //node post
        System.out.println("Node Post " + node.data);
    }



    public static void main(String[] args) {
        int[]data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(data);

        //input can be managed
    }
}