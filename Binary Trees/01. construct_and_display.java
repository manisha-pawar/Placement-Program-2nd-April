import java.util.Stack;

public class Main {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair() {

        }

        Pair(Node node,int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(int[]arr) {
        Stack<Pair>st = new Stack<>();

        Node root = new Node(arr[0]);

        st.push(new Pair(root,0));

        //0 -> waiting for left child
        //1 -> waiting for right child
        //2 -> both left and right are done

        int idx = 1;

        while(st.size() > 0) {
            Pair top = st.peek();

            if(top.state == 0) {
                //waiting for left child
                if(arr[idx] != -1) {
                    Node lc = new Node(arr[idx]);
                    top.node.left = lc;
                    Pair lcp = new Pair(lc,0);
                    st.push(lcp);
                }
                top.state++;
                idx++;
            }
            else if(top.state == 1){
                //waiting for right child
                 if(arr[idx] != -1) {
                    Node rc = new Node(arr[idx]);
                    top.node.right = rc;
                    Pair rcp = new Pair(rc,0);
                    st.push(rcp);
                }
                top.state++;
                idx++;
            }
            else {
                st.pop();
            }
        }

        return root;
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

    public static void main(String[]args) {

        int[]arr = {10,20,-1,40,60,-1,-1,70,-1,-1,30,50,-1,-1,-1};

        Node root = construct(arr);

        display(root);
    }
}