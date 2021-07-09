import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }


    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
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

    static Node predecessor;
    static Node successor;


    static Node prev;
    static Node curr;

    //method 1 : by maintaining prev and curr
    public static void predecessorAndSuccessor(Node node, int data) {
        // write your code here

        predecessor = null;
        successor = null;
        prev = null;
        curr = null;

        travel(node, data);
    }

    public static void travel(Node node, int data) {
        prev = curr;
        curr = node;

        if (curr.data == data) {
            predecessor = prev;
        }

        if (prev != null && prev.data == data) {
            successor = curr;
            return;
        }

        for (Node child: node.children) {
            travel(child, data);
        }
    }




    //method 2 : by maintaining state
    static int state;

    public static void predecessorAndSuccessor(Node node, int data) {
        // write your code here
        predecessor = null;
        successor = null;
        state = 0;

        travel(node, data);
    }

    public static void travel(Node node, int data) {
        //node pre work
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (successor == null && state == 1) {
            successor = node;
            return;
        }


        for (Node child: node.children) {
            travel(child, data);
        }
    }


    public static void main(String[] args) throws Exception {
       //input can be managed
    }

}