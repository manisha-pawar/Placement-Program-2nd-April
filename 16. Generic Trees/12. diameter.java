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

    static int dia;

    public static int diameter(Node root) {
        dia = 0;

        height(root);

        return dia;

    }

    public static int height(Node node) {
        int bht = -1; //best child height
        int sbht = -1; //second best child height

        for (Node child: node.children) {
            int cht = height(child);

            if (cht > bht) {
                sbht = bht;
                bht = cht;
            } else if (cht > sbht) {
                sbht = cht;
            }
        }

        int dist = bht + sbht + 2;

        if (dist > dia) {
            dia = dist;
        }

        return bht + 1;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        System.out.println(diameter(root));
    }

}