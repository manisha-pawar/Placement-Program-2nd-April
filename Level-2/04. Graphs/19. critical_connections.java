//https://leetcode.com/problems/critical-connections-in-a-network/

//based on bridge concept

class Solution {
    int[]disc;
    int[]low;
    int time;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        //create a graph
        ArrayList<Integer>[]graph = new ArrayList[n];
        
        for(int i=0; i < graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        for(int i=0; i < connections.size();i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        List<List<Integer>>ans = new ArrayList<>();
        
        
        disc = new int[n];
        low = new int[n];
        time = 0;
        
        boolean[]vis = new boolean[n];
        bridge(graph,0,-1,vis,ans);
        
        return ans;
    }
    
    public void bridge(ArrayList<Integer>[]graph,int src,int par,boolean[]vis,List<List<Integer>>ans) {
        vis[src] = true;
        disc[src] = low[src] = time;
        time++;
        
        for(int nbr : graph[src]) {
            if(nbr == par) {
                
            }
            else if(vis[nbr] == false) {
                bridge(graph,nbr,src,vis,ans);
                low[src]  = Math.min(low[src],low[nbr]);
            }
            else if(vis[nbr] == true) {
                low[src] = Math.min(low[src],disc[nbr]);
            }
            
            
            if(disc[src] < low[nbr]) {
                List<Integer>cc = new ArrayList<>(); cc.add(src); cc.add(nbr);
                ans.add(cc);
            }
        }
    }
}