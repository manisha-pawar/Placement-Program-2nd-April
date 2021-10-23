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

    public static class Pair {
        TreeNode node;
        int d;

        Pair() {

        }

        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    //clock-wise diagonal
    public static ArrayList < ArrayList < Integer >> diagonalOrder(TreeNode root) {
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        ArrayDeque < Pair > q = new ArrayDeque < > ();
        q.add(new Pair(root, 0));

        while (q.size() > 0) {
            Pair rem = q.remove();
            TreeNode node = rem.node;
            int d = rem.d;

            //work
            if (d == ans.size()) {
                ArrayList < Integer > list = new ArrayList < > ();
                list.add(node.val);
                ans.add(list);
            } else {
                ans.get(d).add(node.val);
            }

            //add children
            if (node.left != null) {
                q.add(new Pair(node.left, d + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, d));
            }
        }

        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList < ArrayList < Integer >> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList < Integer > i: ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j: i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}