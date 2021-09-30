//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG {
    static int idx;
    public static Node constructTree(int post[], int n) {
        idx = n - 1;
        return helper(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Node helper(int[] post, int min, int max) {
        if (idx < 0 || post[idx] < min || post[idx] > max) {
            return null;
        } else {
            Node node = new Node(post[idx]);
            idx--;

            node.right = helper(post, node.data + 1, max);
            node.left = helper(post, min, node.data - 1);

            return node;
        }
    }
}