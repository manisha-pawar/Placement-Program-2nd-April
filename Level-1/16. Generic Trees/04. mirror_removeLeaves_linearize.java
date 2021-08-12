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



    //mirror of generic tree
    public static void mirror(Node node) {
        //faith on each child's family
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            mirror(child);
        }

        //self work -> reverse node's children arraylist
        int lo = 0;
        int hi = node.children.size() - 1;

        while (lo < hi) {
            Node lon = node.children.get(lo);
            Node hin = node.children.get(hi);

            node.children.set(lo, hin);
            node.children.set(hi, lon);

            lo++;
            hi--;
        }
    }



    //remove leaves
    public static void removeLeaves(Node node) {
        //self work
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                //child  is a leaf node
                node.children.remove(i);
            }
        }

        //faith on each child
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            removeLeaves(child);
        }


    }



    //linearize -> using getTail approach
    public static void linearize(Node node) {
        //faith on each faith
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            linearize(child);
        }

        while (node.children.size() > 1) {
            int size = node.children.size();
            Node lc = node.children.get(size - 1); //last child
            Node slc = node.children.get(size - 2); //second last child

            //connections
            node.children.remove(size - 1);
            Node slct = getTail(slc); //second last child tail
            slct.children.add(lc);
        }
    }

    public static Node getTail(Node node) {
        Node temp = node;

        while (temp.children.size() != 0) {
            temp = temp.children.get(0);
        }

        return temp;
    }



    //linearize -> faith (linearize and return tail as well)
    public static void linearize(Node node) {
        // write your code here
        linearize_helper(node);
    }

    public static Node linearize_helper(Node node) {
        if (node.children.size() == 0) {
            return node;
        }

        Node lc = node.children.get(node.children.size() - 1);
        Node otail = linearize_helper(lc); //overall tail

        while (node.children.size() > 1) {
            Node slc = node.children.get(node.children.size() - 2);
            Node slct = linearize_helper(slc);

            //connections
            node.children.remove(node.children.size() - 1);
            slct.children.add(lc);

            lc = slc;
        }

        return otail;
    }

    public static void main(String[] args) {
        int[]data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(data);

        //input can be managed
    }
}