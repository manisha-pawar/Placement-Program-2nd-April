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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = helper(preorder,inorder,0,n-1,0,n-1);
        
        return root;
    }
    
    public TreeNode helper(int[]pre,int[]in,int ps,int pe,int is,int ie) {
        if(ps > pe) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[ps]);
        
        int k = -1;
        for(int i=is; i <= ie;i++) {
            if(in[i] == node.val) {
                k = i;
                break;
            }
        }
        
        int cls = k - is; //count of left subtree elements(wrt node)
        
        node.left = helper(pre,in,ps + 1,ps + cls,is,k-1);
        node.right = helper(pre,in,ps + cls + 1,pe,k+1,ie);
        
        return node;
    }
    
}