class Solution
{
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
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        Stack<Integer>st = new Stack<>();
        boolean[]vis = new boolean[V];
        
        //1. perform dfs and fill stack in postorder
        for(int i=0; i < V;i++) {
            if(vis[i] == false) {
                dfs(i,graph,vis,st);
            }
        }
        
        //2. reverse the graph
        ArrayList<ArrayList<Integer>>revGraph = new ArrayList<>();
        for(int i=0; i < V;i++) {
            ArrayList<Integer>list = new ArrayList<>();
            revGraph.add(list);
        }
        
        
        for(int i = 0; i < V;i++) {
            for(int nbr : graph.get(i)) {
                revGraph.get(nbr).add(i);
            }
        }
        
        
        //3. now perform dfs on revGraph (using the order in the stack), and count of dfs = strongly connected comp
        vis = new boolean[V];
        int scc = 0;
        while(st.size() != 0) {
            int s = st.pop();
            if(vis[s] == false) {
                dfs(s,revGraph,vis);
                scc++;
            }
        }
        
        return scc;
    }
}
