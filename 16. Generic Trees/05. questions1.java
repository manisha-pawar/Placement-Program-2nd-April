//find , node to root path, lowest common ancestor, distance between two nodes
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

   

    //find 
    public static boolean find(Node node, int data) {
        //self check
        if (node.data == data) {
            return true;
        }

        //faith on each child
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            boolean ificf = find(child, data); //is found in child family

            if (ificf == true) {
                return true;
            }
        }


        return false;

    }



    //node to root path
    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        //self check
        if (node.data == data) {
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(node.data);
            return list;
        }

        //faith on each child
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            ArrayList < Integer > n2cp = nodeToRootPath(child, data); //node to child path

            if (n2cp.size() > 0) {
                //data exists in child family
                n2cp.add(node.data); //node to child path -> node to root path
                return n2cp;
            }
        }

        return new ArrayList < > ();

    }



    //lowest common ancestor
    public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        return p1.get(i + 1);
    }



    //distance between two nodes
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        // write your code here
        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        int dist1 = (i + 1) - 0; //d1 to lca distance
        int dist2 = (j + 1) - 0; //d2 to lca distance

        int dist = dist1 + dist2;

        return dist;
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