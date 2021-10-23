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
    static int minCam;
    
    public int minCameraCover(TreeNode root) {
        minCam = 0;
        int state = helper(root);
        
        if(state == -1) {
            minCam++;
        }
        
        return minCam;
    }
    
    // camera places at me : 1
    // covered : 0
    // not covered(need) : -1
    
    public static int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int lcs = helper(root.left);
        int rcs = helper(root.right);
        
        if(lcs == -1 || rcs == -1) {
            //you have to place camera at yourself
            minCam++;
            return 1;
        }
        else if(lcs == 1 || rcs == 1) {
            //due to camera on a child, I am covered
            return 0;
        }
        else {
            //i am not covered
            return -1;
        }
    }
    
}