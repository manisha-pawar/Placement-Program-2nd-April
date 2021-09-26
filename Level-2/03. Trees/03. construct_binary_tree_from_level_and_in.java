class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        map = new HashMap<>(); //ele vs its index in inorder
        
        for(int i=0; i < inord.length;i++) {
            map.put(inord[i],i);
        }
        
        return helper(level,inord,0,inord.length-1);
        
    }
    
    HashMap<Integer,Integer>map;
    
    Node helper(int[]level,int[]inorder,int is,int ie) {
        if(is > ie) {
            return null;
        }        
        
        Node node = new Node(level[0]);
        int k = map.get(node.data);
        
        int ls = k - is;
        int rs = level.length - ls - 1;
        
        int[]llo = new int[ls]; //left level order
        int[]rlo = new int[rs]; //right level order
        
        int p = 0,q = 0;
        
        for(int i = 1; i < level.length;i++) {
            int idx = map.get(level[i]);
            
            if(idx < k) {
                llo[p++] = level[i];
            }
            else if(idx > k){
                rlo[q++] = level[i];
            }
        }
        
        node.left = helper(llo,inorder,is,k-1);
        node.right = helper(rlo,inorder,k+1,ie);
        
        return node;
    }
    
   
}
