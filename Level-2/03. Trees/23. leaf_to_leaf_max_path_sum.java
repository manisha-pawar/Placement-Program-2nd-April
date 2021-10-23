class Solution
{
    static class Pair {
        int n2l; //node to leaf max path sum
        int l2l; //leaf to leaf max path sum
        
        Pair() {
            
        }
        
        Pair(int n2l,int l2l) {
            this.n2l = n2l;
            this.l2l = l2l;
        }
    }
    
    //leaf to leaf max path sum
    int maxPathSum(Node root)
    { 
        Pair ans = helper(root);
        
        //due to note
        if((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return Math.max(ans.n2l,ans.l2l);
        }
        
        return ans.l2l;
    } 
    
    public static Pair helper(Node node) {
        if(node == null) {
            return new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        
        if(node.left == null && node.right == null) {
            return new Pair(node.data,Integer.MIN_VALUE);
        }
        
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        int nc = Integer.MIN_VALUE; //node contender
        
        if(node.left != null && node.right != null) {
            nc = lp.n2l + node.data + rp.n2l;
        }
        
        int n2l = Math.max(lp.n2l,rp.n2l) + node.data;
        int l2l = Math.max(Math.max(lp.l2l,rp.l2l),nc);
        
        Pair np = new Pair(n2l,l2l);
        return np;
    }   
}