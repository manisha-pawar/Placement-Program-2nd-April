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

//using recursion
class Solution {
    static TreeNode prev;
    static TreeNode fn; //first node
    static TreeNode sn; //second node
    
    public void recoverTree(TreeNode root) {
        prev = fn = sn = null;
        
        helper(root);
        
        //swap the data of fn and sn
        int temp = fn.val;
        fn.val = sn.val;
        sn.val = temp;
    }
    
    public static void helper(TreeNode node) {
        if(node == null) {
            return;
        }
        
        helper(node.left);
        
        
        //work and update(inorder)
        if(prev != null && prev.val >= node.val) {
            if(sn == null) {
                fn = prev;
            }
            sn = node;
        }
        prev = node;
        
        helper(node.right);
    }
}




//using morris traversal
class Solution {
    
    public static TreeNode rightMostNode(TreeNode lc,TreeNode curr) {
        TreeNode rmn = lc;
        
        while(rmn.right != null && rmn.right != curr) {
            rmn = rmn.right;
        }
        
        return rmn;
    }
    
    public void recoverTree(TreeNode root) {
        //morris inorder traversal
        TreeNode prev = null;
        TreeNode fn = null;
        TreeNode sn = null;
    
        TreeNode curr = root;
        
        while(curr != null) {
            TreeNode lc = curr.left;
            
            if(lc == null) {
                if(prev != null && prev.val >= curr.val) {
                    if(fn == null) {
                        fn = prev;
                    }
                    sn = curr;
                }
                prev = curr;
                
                curr  = curr.right;
            }
            else {
                TreeNode rmn = rightMostNode(lc,curr);
                
                if(rmn.right == null) {
                    //left subtree is not visited
                    rmn.right = curr;
                    curr = curr.left;
                }
                else {
                    //left subtree is visited
                    if(prev.val >= curr.val) {
                        if(fn == null) {
                            fn = prev;
                        }
                        sn = curr;
                    }
                    prev = curr;
                    
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
        
        //swap the data of fn and sn
        int temp = fn.val;
        fn.val = sn.val;
        sn.val = temp;
    }
}





















