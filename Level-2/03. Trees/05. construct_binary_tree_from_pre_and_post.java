/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return helper(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    public static TreeNode helper(int[] preorder, int prs, int pre, int[] postorder, int pos, int poe) {
        if (pos > poe) {
            return null;
        }

        if (prs == pre) {
            return new TreeNode(preorder[prs]);
        }

        TreeNode node = new TreeNode(preorder[prs]);

        int val = preorder[prs + 1];
        int idx = -1;

        for (int i = pos; i <= poe; i++) {
            if (postorder[i] == val) {
                idx = i;
                break;
            }
        }

        int cls = idx - pos + 1;

        node.left = helper(preorder, prs + 1, prs + cls, postorder, pos, idx);
        node.right = helper(preorder, prs + cls + 1, pre, postorder, idx + 1, poe - 1);

        return node;
    }
}