import java.util.*;

public class Main {

    public static class Node {
        int data;
        Node left;
        Node right;
        int bf; //balancing factor 
        int ht; //height

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node root) {
        if(root == null) {
            return;
        }

        String str = " <- "+ root.data + " -> ";
        String l = (root.left != null) ?  (root.left.data + "") : (".");
        String r = (root.right != null) ? (root.right.data + ""): (".");

        System.out.println(l + str + r);

        display(root.left);
        display(root.right); 
    }

    public static Node add(Node node,int data) {
        if(node == null) {
            return new Node(data);
        }

        if(node.data < data) {
            node.right = add(node.right,data);
        }
        else if(node.data > data) {
            node.left = add(node.left,data);
        }
        else {
            //do nothing
        }

        updateHeightAndBalance(node);

        return checkAndSolve(node);
    }

    public static Node delete(Node node,int data) {
        if(node == null) {
            //data is not present in tree
            return null;
        }

        if(node.data < data) {
            node.right = delete(node.right,data);
        }
        else if(node.data > data) {
            node.left = delete(node.left,data);
        }
        else {
            if(node.left != null && node.right != null) {
                //both child
                int lmax = max(node.left);
                node.data = lmax;
                node.left = delete(node.left,lmax);
            }
            else if(node.left != null) {
                //single child -> only left child
                return node.left;
            }
            else if(node.right != null) {
                //single child -> only right child
                return node.right;
            }
            else {
                //no child
                return null;
            }
        }

        updateHeightAndBalance(node);

        return checkAndSolve(node);
    }

    public static int max(Node node) {
        if(node.right != null) {
            return max(node.right);
        }
        else {
            return node.data;
        }
    }

    public static Node solveRR(Node node) {
        //we have to do left rotation at node's right child

        Node rc = node.right; //right child of node
        Node temp = rc.left; //left child of rc

        rc.left = node;
        node.right = temp;

        updateHeightAndBalance(node);
        updateHeightAndBalance(rc);
        
        return rc;
    }

    public static Node solveLL(Node node) {
        //we have to do right rotation at node's left child

        Node lc = node.left; //left child of node
        Node temp = lc.right; //right child of lc

        lc.right = node;
        node.left = temp;

        updateHeightAndBalance(node);
        updateHeightAndBalance(lc);

        return lc;
    }

    public static Node checkAndSolve(Node node) {
        if(node.bf > 1 || node.bf < -1) {
            //problem is detected, identify and then solve it
            if(node.bf > 0) {
                if(node.left.bf > 0) {
                    //LL problem
                    return solveLL(node);
                }
                else {
                    //LR problem
                    node.left = solveRR(node.left);
                    return solveLL(node);
                }
            }
            else {
                if(node.right.bf > 0) {
                    //RL problem
                    node.right = solveLL(node.right);
                    return solveRR(node);
                }
                else {
                    //RR problem
                    return solveRR(node);
                }
            }

        }
        else {
            return node;
        }
    }

    public static void updateHeightAndBalance(Node node) {
        if(node == null) {
            return;
        }

        int lht = node.left == null ? -1 : node.left.ht;
        int rht = node.right == null ? -1 : node.right.ht;

        int ht = Math.max(lht,rht) + 1;
        int bf = lht - rht;

        node.ht = ht;
        node.bf = bf;
    }

    public static void main(String[]args) {
        Node root = null;
        int[]arr = {10,30,40,35,90,5,50,8};

        for(int i=0; i < arr.length;i++) {
            root = add(root,arr[i]);
        }

        root = delete(root,30);
        root = delete(root,8);

        display(root);
    }
}