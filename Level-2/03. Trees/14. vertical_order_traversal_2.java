//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

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
    
    public static class Pair implements Comparable<Pair>{
        TreeNode node;
        int x;
        int y;
        
        Pair() {
            
        }
        
        Pair(TreeNode node,int x,int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
        
        //this < o -> -ve
        //this > o -> +ve
        //this == o -> 0
        
        public int compareTo(Pair o) {
            if(this.y != o.y) {
                return this.y - o.y;
            }
            else if(this.x != o.x) {
                return this.x - o.x;
            }
            else {
                return this.node.val - o.node.val;
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        
        pq.add(new Pair(root,0,0));
        int min = Integer.MAX_VALUE; //min vertical line number
        int max = Integer.MIN_VALUE; //max vertical line number
        
        while(pq.size() > 0) {
            Pair rem = pq.remove();
            TreeNode node = rem.node;
            int x = rem.x;
            int y = rem.y;
            
            min = Math.min(min,x);
            max = Math.max(max,x);
            
            if(map.containsKey(x) == false) {
                ArrayList<Integer>list = new ArrayList<>();
                list.add(node.val);
                map.put(x,list);
            }
            else {
                ArrayList<Integer>list = map.get(x);
                list.add(node.val);
                map.put(x,list);
            }
            
            
            if(node.left != null) {
                pq.add(new Pair(node.left,x-1,y+1));
            }
            if(node.right != null) {
                pq.add(new Pair(node.right,x+1,y+1));
            }
        }
        
        List<List<Integer>>ans = new ArrayList<>();
        for(int i = min; i <= max;i++) {
            ans.add(map.get(i));
        }
        
        return ans;
        
    }
}