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
        int vl; //vertical line no.

        Pair(TreeNode node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    static int min;
    static int max;

    public static void width(TreeNode node, int vl) {
        if (node == null) {
            return;
        }

        min = Math.min(vl, min);
        max = Math.max(vl, max);

        width(node.left, vl - 1);
        width(node.right, vl + 1);
    }
    
    public static ArrayList < ArrayList < Integer >> verticalOrderTraversal(TreeNode root) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        width(root, 0);

        int rvl = -min; //root's vertical line
        int w = max - min + 1;


        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        ArrayDeque < Pair > q = new ArrayDeque < > ();
        q.add(new Pair(root, rvl));

        for (int i = 0; i < w; i++) {
            ans.add(new ArrayList < > ());
        }

        while (q.size() > 0) {
            //remove
            Pair rem = q.remove();

            //work
            ans.get(rem.vl).add(rem.node.val);

            //add children
            if (rem.node.left != null) {
                q.add(new Pair(rem.node.left, rem.vl - 1));
            }
            if (rem.node.right != null) {
                q.add(new Pair(rem.node.right, rem.vl + 1));
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

        ArrayList < ArrayList < Integer >> ans = verticalOrderTraversal(root);
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