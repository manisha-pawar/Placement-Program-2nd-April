//https://practice.geeksforgeeks.org/problems/mother-vertex/1/

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    
    public static void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]vis,Stack<Integer>st) {
        vis[src] = true;
        
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfs(nbr,graph,vis,st);
            }
        }
        
        st.push(src);
    }
    
    public static void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]vis) {
        vis[src] = true;
        
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfs(nbr,graph,vis);
            }
        }
    }
    
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        //1. perform dfs and fill the stack in post-order
        boolean[]vis = new boolean[adj.size()];
        Stack<Integer>st = new Stack<>();
        
        for(int i=0; i < adj.size();i++) {
            if(vis[i] == false) {
                dfs(i,adj,vis,st);
            }
        }
        
        //2. check if potential mother vertex is a mother vertex
        vis = new boolean[adj.size()];
        
        dfs(st.peek(),adj,vis);
        
        for(int i = 0; i < adj.size();i++) {
            if(vis[i] == false) {
                return -1;
            }
        }
        
        return st.peek();
    }
}