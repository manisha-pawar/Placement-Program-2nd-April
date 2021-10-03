//1. top view of binary tree
class Solution
{
    static int min;
    static int max;
    
    public static class Pair {
        Node node;
        int vl; //vertical line no.
        
        Pair(Node node,int vl) {
            this.node = node;
            this.vl = vl;
        }
    }
    
    public static void width(Node node,int vl) {
        if(node == null) {
            return;
        }
        
        min = Math.min(vl,min);
        max = Math.max(vl,max);
        
        width(node.left,vl-1);
        width(node.right,vl+1);
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        
        width(root,0);
        
        int rvl = -min; //root's vertical line
        int w = max - min + 1;
        
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        q.add(new Pair(root,rvl));
        
        for(int i=0; i < w;i++) {
            ans.add(-1);
        }
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            if(ans.get(rem.vl) == -1) {
                ans.set(rem.vl,rem.node.data);
            }
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.vl-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.vl+1));
            }
        }
        
        return ans;
        
    }
}





//2. bottom view of binary tree
class Solution
{
    static int min;
    static int max;
    
    public static class Pair {
        Node node;
        int vl; //vertical line no.
        
        Pair(Node node,int vl) {
            this.node = node;
            this.vl = vl;
        }
    }
    
    public static void width(Node node,int vl) {
        if(node == null) {
            return;
        }
        
        min = Math.min(vl,min);
        max = Math.max(vl,max);
        
        width(node.left,vl-1);
        width(node.right,vl+1);
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root)
    {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        
        width(root,0);
        
        int rvl = -min; //root's vertical line
        int w = max - min + 1;
        
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        q.add(new Pair(root,rvl));
        
        for(int i=0; i < w;i++) {
            ans.add(-1);
        }
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            ans.set(rem.vl,rem.node.data);
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.vl-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.vl+1));
            }
        }
        
        return ans;
        
    }
}