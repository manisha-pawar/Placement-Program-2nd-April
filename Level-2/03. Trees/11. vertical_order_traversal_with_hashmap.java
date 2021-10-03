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

        Pair() {

        }

        Pair(TreeNode node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    public static ArrayList < ArrayList < Integer >> verticalOrderTraversal(TreeNode root) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();
        q.add(new Pair(root, 0));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashMap < Integer, ArrayList < Integer >> map = new HashMap < > (); //vl vs nodes on that vl

        while (q.size() > 0) {
            //remove
            Pair rem = q.remove();
            min = Math.min(min, rem.vl);
            max = Math.max(max, rem.vl);

            //work
            if (map.containsKey(rem.vl) == false) {
                ArrayList < Integer > list = new ArrayList < > ();
                list.add(rem.node.val);
                map.put(rem.vl, list);
            } else {
                ArrayList < Integer > list = map.get(rem.vl);
                list.add(rem.node.val);
                map.put(rem.vl, list);
            }

            //add children
            if (rem.node.left != null) {
                q.add(new Pair(rem.node.left, rem.vl - 1));
            }
            if (rem.node.right != null) {
                q.add(new Pair(rem.node.right, rem.vl + 1));
            }
        }

        //ans creation
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
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