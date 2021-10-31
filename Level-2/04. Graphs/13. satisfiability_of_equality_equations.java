//https://leetcode.com/problems/satisfiability-of-equality-equations/

class Solution {
    static int[]par;
    static int[]rank;
    
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];
        
        for(int i=0; i < par.length;i++) {
            par[i] = i;
            rank[i] = 0;
        }
        
        //work first on the equations with "==", to group similar operands
        for(String exp : equations) {
            char op1 = exp.charAt(0);
            char op2 = exp.charAt(3);
            
            if(exp.charAt(1) == '=') {
                int x = op1 - 'a';
                int y = op2 - 'a';
                
                union(x,y);
            }
        }
        
        //cheking all equations with "!="
        for(String exp : equations) {
            char op1 = exp.charAt(0);
            char op2 = exp.charAt(3);
            
            if(exp.charAt(1) == '!') {
                int x = op1 - 'a';
                int y = op2 - 'a';
                
                int lx = find(x);
                int ly = find(y);
                
                if(lx == ly) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }
        else {
            int ans = find(par[x]);
            par[x] = ans;
            return ans;
        }
    }
    
    public static void union(int x,int y) {
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly) {
            if(rank[lx] < rank[ly]) {
                par[lx] = ly;
            }
            else if(rank[lx] > rank[ly]) {
                par[ly] = lx;
            }
            else {
                par[lx] = ly;
                rank[ly]++;
            }
        }
    }
}