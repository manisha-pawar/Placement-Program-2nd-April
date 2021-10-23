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
    public static class Pair {
        int incMP; //max profit when this house is included in robbery
        int excMP; //max profit when this house is excluded from robbery
        
        Pair() {
            
        }
        
        Pair(int incMP,int excMP) {
            this.incMP = incMP;
            this.excMP = excMP;
        }
    }
    
    public int rob(TreeNode root) {
        Pair ans = helper(root);
        return Math.max(ans.incMP,ans.excMP);
    }
    
    
    public static Pair helper(TreeNode node) {
        if(node == null) {
            return new Pair(0,0);
        }
        
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        int incMP = node.val + lp.excMP + rp.excMP;
        int excMP = Math.max(lp.incMP,lp.excMP) + Math.max(rp.incMP,rp.excMP);
        
        return new Pair(incMP,excMP);
    }
    
}