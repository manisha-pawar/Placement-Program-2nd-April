import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static TreeNode rightMostNode(TreeNode lc, TreeNode curr) {
        TreeNode rmn = lc;

        while (rmn.right != null && rmn.right != curr) {
            rmn = rmn.right;
        }

        return rmn;
    }



    //inorder morris traversal
    public static ArrayList < Integer > morrisInTraversal(TreeNode node) {
        ArrayList < Integer > ans = new ArrayList < > ();

        TreeNode curr = node;

        while (curr != null) {
            TreeNode lc = curr.left;

            if (lc == null) {
                //left child is null
                ans.add(curr.val); //work
                curr = curr.right;
            } else {
                TreeNode rmn = rightMostNode(lc, curr);

                if (rmn.right == null) {
                    //left subtree is not visited, but before visiting it we will create a thread
                    rmn.right = curr;
                    curr = curr.left;
                } else if (rmn.right == curr) {
                    //left subtree is visited, break the thread
                    ans.add(curr.val);
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }





    //preorder morris traversal
    public static ArrayList < Integer > morrisPreTraversal(TreeNode node) {
        ArrayList < Integer > ans = new ArrayList < > ();

        TreeNode curr = node;

        while (curr != null) {
            TreeNode lc = curr.left;

            if (lc == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rmn = rightMostNode(lc, curr);

                if (rmn.right == null) {
                    //left subtree is not visited
                    ans.add(curr.val);
                    rmn.right = curr;
                    curr = curr.left;
                } else {
                    //left subtree is visited
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }




    //postorder morris traversal - use reverse euler preorder traversal for this
    public ArrayList < Integer > postorderTraversal(TreeNode root) {

        //reverse euler preorder -> NRL

        ArrayList < Integer > ans = new ArrayList < > ();

        TreeNode curr = root;

        while (curr != null) {
            TreeNode rc = curr.right;

            if (rc == null) {
                ans.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode lmn = LeftMostNode(rc, curr);

                if (lmn.left == null) {
                    //right subtree is not visited
                    ans.add(curr.val);
                    lmn.left = curr;
                    curr = curr.right;
                } else {
                    //right subtree is visited
                    lmn.left = null;
                    curr = curr.left;
                }
            }
        }

        //ans -> NRL
        //postorder = rev(ans) = LRN

        Collections.reverse(ans);
        return ans;
    }

    public static TreeNode LeftMostNode(TreeNode rc, TreeNode curr) {
        TreeNode lmn = rc;

        while (lmn.left != null && lmn.left != curr) {
            lmn = lmn.left;
        }

        return lmn;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList < Integer > ans = morrisInTraversal(root);
        for (Integer i: ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}