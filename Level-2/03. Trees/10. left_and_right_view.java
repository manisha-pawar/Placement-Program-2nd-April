//1. left view of binary tree
class Tree {
    //Function to return list containing elements of left view of binary tree.
    ArrayList < Integer > leftView(Node root) {

        ArrayList < Integer > lv = new ArrayList < > ();

        if (root == null) {
            return lv;
        }

        ArrayDeque < Node > q = new ArrayDeque < > ();
        q.add(root);

        while (q.size() > 0) {
            int count = q.size();

            lv.add(q.peek().data);

            while (count-- > 0) {
                //remove
                Node rem = q.remove();

                //add children
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }

        }

        return lv;
    }
}



//2. right view of binary tree
class Solution {
    //Function to return list containing elements of right view of binary tree.
    ArrayList < Integer > rightView(Node root) {
        
        ArrayList < Integer > rv = new ArrayList < > ();

        if (root == null) {
            return rv;
        }

        ArrayDeque < Node > q = new ArrayDeque < > ();
        q.add(root);

        while (q.size() > 0) {
            int count = q.size();
            int ld = -1; //last data of this level

            while (count-- > 0) {
                //remove
                Node rem = q.remove();
                ld = rem.data;

                //add children
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }

            rv.add(ld);

        }

        return rv;
    }
}