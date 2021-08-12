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




    //level-order
    public static void levelOrder(Node root) {
        Queue < Node > q = new ArrayDeque < > ();

        q.add(root);

        while (q.size() > 0) {
            //remove
            Node rem = q.remove();

            //print
            System.out.print(rem.data + " ");

            //add children
            for (int i = 0; i < rem.children.size(); i++) {
                Node child = rem.children.get(i);
                q.add(child);
            }
        }

        System.out.println(".");

    }



    //level-order linewise -> two queues approach
    public static void levelOrderLinewise(Node root) {
        Queue < Node > mq = new ArrayDeque < > (); //main queue
        Queue < Node > cq = new ArrayDeque < > (); //child queue

        mq.add(root);

        while (mq.size() > 0) {
            //remove
            Node rem = mq.remove();

            //print
            System.out.print(rem.data + " ");


            //add children
            for (int i = 0; i < rem.children.size(); i++) {
                Node child = rem.children.get(i);
                cq.add(child);
            }

            //if rem was main queue's last element
            if (mq.size() == 0) {
                //1
                System.out.println();
                mq = cq;
                cq = new ArrayDeque < > ();


            }
        }
    }




    //level-order linewise -> delimiter approach
    public static void levelOrderLinewise(Node root) {
        Queue < Node > q = new ArrayDeque < > ();

        q.add(root);
        q.add(new Node(-1));

        while (q.size() > 0) {
            //remove
            Node rem = q.remove();

            if (rem.data == -1) {
                System.out.println();

                if (q.size() == 0) {
                    break;
                }

                q.add(rem);
                continue;
            }

            //print
            System.out.print(rem.data + " ");

            //add children
            for (int i = 0; i < rem.children.size(); i++) {
                Node child = rem.children.get(i);
                q.add(child);
            }
        }
    }





    //level-order linewise -> prev level count method
    public static void levelOrderLinewise(Node root) {
        Queue < Node > q = new ArrayDeque < > ();

        q.add(root);

        while (q.size() > 0) {
            int count = q.size();

            while (count-- > 0) {
                //remove
                Node rem = q.remove();

                //print
                System.out.print(rem.data + " ");

                //add children
                for (int i = 0; i < rem.children.size(); i++) {
                    Node child = rem.children.get(i);
                    q.add(child);
                }
            }

            System.out.println();
        }
    }





    //level-order linewise zig-zag
    public static void levelOrderLinewiseZZ(Node node) {
        // write your code here
        int lev = 0;
        Stack < Node > ms = new Stack < > ();
        Stack < Node > cs = new Stack < > ();

        ms.push(node);

        while (ms.size() > 0) {
            //remove
            Node rem = ms.pop();

            //print
            System.out.print(rem.data + " ");

            //add children
            if (lev % 2 == 0) {
                //push L->R
                for (int i = 0; i < rem.children.size(); i++) {
                    Node child = rem.children.get(i);
                    cs.push(child);
                }
            } else {
                //push R->L
                for (int i = rem.children.size() - 1; i >= 0; i--) {
                    Node child = rem.children.get(i);
                    cs.push(child);
                }
            }

            if (ms.size() == 0) {
                lev++;
                System.out.println();
                ms = cs;
                cs = new Stack < > ();
            }
        }
    }


    public static void main(String[] args) {
        int[]data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(data);

        //input can be managed
    }
}