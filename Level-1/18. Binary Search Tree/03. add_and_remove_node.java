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



    //add node to a bst
    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }

        if (node.data < data) {
            //go to right
            node.right = add(node.right, data);
        } else if (node.data > data) {
            //go to left
            node.left = add(node.left, data);
        } else {
            //do nothing
        }

        return node;
    }



    //remove node from a bst
    public static Node remove(Node node, int data) {
        if (node == null) {
            //data is not present in the tree
            return null;
        }

        if (node.data < data) {
            node.right = remove(node.right, data);
        } else if (node.data > data) {
            node.left = remove(node.left, data);
        } else {
            //perform removal
            if (node.left == null && node.right == null) {
                //node is a leaf node
                return null;
            } else if (node.left == null) {
                //single child -> right child
                return node.right;
            } else if (node.right == null) {
                //single child -> left child
                return node.left;
            } else {
                //node has both the childs
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            }
        }

        return node;
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}