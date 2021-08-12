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

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data < data) {
            return find(node.right, data);
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }



    //1. using find method T : o(n*h) , S : o(h)
    public static void targetSumPair(Node node, Node root, int target) {
        if (node == null) {
            return;
        }

        targetSumPair(node.left, root, target);

        //work
        int rem_tar = target - node.data;

        if (rem_tar > node.data) {
            if (find(root, rem_tar) == true) {
                System.out.println(node.data + " " + rem_tar);
            }
        }

        targetSumPair(node.right, root, target);
    }



    //2. using inorder property T : o(n), S : o(n)
    public static void inorder(Node node, ArrayList < Integer > list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    public static void targetSumPair(Node root, int target) {
        ArrayList < Integer > list = new ArrayList < > ();
        inorder(root, list);

        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            if (list.get(lo) + list.get(hi) == target) {
                System.out.println(list.get(lo) + " " + list.get(hi));
                lo++;
                hi--;
            } else if (list.get(lo) + list.get(hi) > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        // write your code here
    }

}