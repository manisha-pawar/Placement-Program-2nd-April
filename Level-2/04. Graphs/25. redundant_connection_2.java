//https://leetcode.com/problems/redundant-connection-ii/

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
    
    public boolean union(int u,int v) {
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
            
            return true;
        }
        else {
            //cycle
            return false;
        }
    }
    
    public int dsu(int bli,int[][]edges) {
        int n = edges.length;
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i < n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0; i < edges.length;i++) {
            if(bli == i) {
                continue;
            }
            
            int u = edges[i][0]; u--;
            int v = edges[i][1]; v--;
            
            boolean temp = union(u,v);
            
            if(temp == false) {
                return i;
            }
        }
        
        return -1;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        
        int[]indegree = new int[n];
        Arrays.fill(indegree,-1);
        
        int bl1 = -1;
        int bl2 = -1;
        for(int i=0; i < edges.length;i++) {
            int u = edges[i][0]; u--;
            int v = edges[i][1]; v--;
            
            if(indegree[v] == -1) {
                indegree[v] = i;
            }
            else {
                bl1 = indegree[v];
                bl2 = i;
                break;
            }
        }
        
        if(bl1 == -1) {
            //case 1 : cycle
            int ei = dsu(-1,edges);
            return edges[ei];
        }
        else {
            //case 2 : 2 parent, case3 : 2 parent & cycle
            int ei = dsu(bl2,edges);
            if(ei == -1) {
                return edges[bl2];
            }
            else {
                return edges[bl1];
            }
        }
        
    }
}