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
    static TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }
    
    public static boolean helper(TreeNode node) {
        if(node == null) {
            return true;
        }
        
        boolean lans = helper(node.left);
        
        //work and update (inorder)
        if(prev != null && prev.val >= node.val) {
            return false;
        }
        prev = node;
        
        boolean rans = helper(node.right);
        
        return lans && rans;
    }
    
    
}