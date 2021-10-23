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


    //using return type
    public static ArrayList < ArrayList < Integer >> rootToAllLeafPath(TreeNode root) {
        if (root == null) {
            return new ArrayList < > ();
        }

        if (root.left == null && root.right == null) {
            ArrayList < ArrayList < Integer >> bl = new ArrayList < > ();
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(root.val);
            bl.add(list);
            return bl;
        }

        ArrayList < ArrayList < Integer >> lans = rootToAllLeafPath(root.left); //left child to all leaf path
        ArrayList < ArrayList < Integer >> rans = rootToAllLeafPath(root.right); //right child to all leaf path

        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        for (ArrayList < Integer > path: lans) {
            //path is left child to leaf path
            path.add(0, root.val);
            ans.add(path);
        }


        for (ArrayList < Integer > path: rans) {
            //path is right child to leaf path
            path.add(0, root.val);
            ans.add(path);
        }

        return ans;
    }





    //using recursion on the way up
    public static ArrayList < ArrayList < Integer >> rootToAllLeafPath(TreeNode root) {
        ArrayList < ArrayList < Integer >> oans = new ArrayList < > ();
        ArrayList < Integer > list = new ArrayList < > ();

        helper(root, list, oans);

        return oans;
    }

    public static void helper(TreeNode node, ArrayList < Integer > list, ArrayList < ArrayList < Integer >> oans) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
            ArrayList < Integer > cl = new ArrayList < > (list);
            oans.add(cl);
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        helper(node.left, list, oans);
        helper(node.right, list, oans);
        list.remove(list.size() - 1);

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

        ArrayList < ArrayList < Integer >> ans = rootToAllLeafPath(root);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList < Integer > al: ans) {
            for (Integer ele: al)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}