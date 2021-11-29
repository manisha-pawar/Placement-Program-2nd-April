//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[]parA = new int[n];
        int[]parB = new int[n];
        int[]rankA = new int[n];
        int[]rankB = new int[n];
        
        
        for(int i=0; i < n;i++) {
            parA[i] = parB[i] = i;
            rankA[i] = rankB[i] = 0;
        }
        
        
        Arrays.sort(edges,(a,b)->{
            //a < b -> -ve
            //a > b -> +ve
            //a == b
            
            if(a[0] == 3) {
                return -1;
            }
            else if(b[0] == 3) {
                return 1;
            }
            else {
                return 0;
            }
        });
        
        int rc = 0;
        int cA = 1;
        int cB = 1;
        
        for(int i=0; i < edges.length;i++) {
            int type = edges[i][0];
            int u =  edges[i][1]; u--;
            int v = edges[i][2]; v--;
            
            
            if(type == 1) {
                //Alice
                boolean erA = union(parA,rankA,u,v); //edge required for alice
                
                if(erA == false) {
                    rc++;
                }
                else {
                    cA++;
                }
            }
            else if(type == 2) {
                //Bob
                boolean erB = union(parB,rankB,u,v); //edge required for bob
                
                if(erB == false) {
                    rc++;
                } 
                else {
                    cB++;
                }
            }
            else {
                //both
                boolean erA = union(parA,rankA,u,v);
                boolean erB = union(parB,rankB,u,v);
                
                if(erA == false && erB == false) {
                    rc++;
                }
                else {
                    cA++;
                    cB++;
                }
            }
        }
        
        if(cA == n && cB == n) {
            return rc;
        }
        else {
            return -1;
        }
        
    }
    
    
    public static int find(int[]par,int x) {
        if(par[x] == x) {
            return x;
        }
        else {
            int ans = find(par,par[x]);
            par[x] = ans;
            return ans;
        }
    }
    
    
    
    public static boolean union(int[]par,int[]rank,int u,int v) {
        int lu = find(par,u);
        int lv = find(par,v);
        
        if(lu != lv) {
            //merging is required
            if(rank[lu] < rank[lv]) {
                par[lu] = lv;
            }
            else if(rank[lu] > rank[lv]) {
                par[lv] = lu;
            }
            else {
                par[lu] = lv;
                rank[lv]++;
            }
            
            return true;
            
        }
        else {
            return false;   
        }
    }
}