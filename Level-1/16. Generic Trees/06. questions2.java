//are trees similar, are trees mirror, is tree symmetric

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




    //are trees similar
    public static boolean areSimilar(Node n1, Node n2) {
        //self check
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            boolean areSimilarChild = areSimilar(c1, c2);

            if (areSimilarChild == false) {
                return false;
            }
        }

        return true;
    }



    //are trees mirror
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            int s2 = n2.children.size();
            Node c2 = n2.children.get(s2 - i - 1);

            boolean areMirrorChild = areMirror(c1, c2);

            if (areMirrorChild == false) {
                return false;
            }

        }

        return true;

    }



    //is tree symmetric
    public static boolean IsSymmetric(Node node) {
        // write your code here
        return areMirror(node, node);
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

    public static void main(String[] args) {
        int[]data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(data);

        //input can be managed
    }
}