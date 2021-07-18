//leetcode 108 solution https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums,0,nums.length-1);
        return root;
    }
    
    public TreeNode helper(int[]nums,int lo,int hi) {
        if(lo > hi) {
            return null;
        }
        
        int mid = (lo + hi)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = helper(nums,lo,mid-1);
        node.right = helper(nums,mid+1,hi);
        
        return node;
    }
}