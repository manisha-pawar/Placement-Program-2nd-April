//https://leetcode.com/problems/redundant-connection/

class Solution {
    int[]parent;
    int[]rank;
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        else {
            int ans = find(parent[x]);
            parent[x] = ans;
            return ans;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n  = edges.length;
        parent = new int[n];
        rank = new int[n];
        
        
        for(int i=0; i < n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        
        for(int i=0; i < edges.length;i++) {
            int u = edges[i][0]; u--;
            int v = edges[i][1]; v--;
            
            int lu = find(u);
            int lv = find(v);
            
            if(lu != lv) {
                //merge
                if(rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                }
                else if(rank[lu] > rank[lv]) {
                    parent[lv] = lu;
                }
                else {
                    parent[lu] = lv;
                    rank[lv]++;
                }
            }
            else {
                return edges[i];
            }
        }
        
        int[]arr = {0,0};
        return arr;
    }
}