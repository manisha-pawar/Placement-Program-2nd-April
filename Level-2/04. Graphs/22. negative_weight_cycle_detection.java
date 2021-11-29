//https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int src = 0;
        int[]path = new int[n];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[src] = 0;
	   
        for(int itr = 1; itr <= n-1;itr++) {
	        for(int[]edge : edges) {
	            int u = edge[0];
	            int v = edge[1];
	            int wt = edge[2];
	            
	            
	            if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
	                path[v] = path[u] + wt;
	            }
	        }
	    }
	    
	    //vth iteration
	     for(int[]edge : edges) {
    	       int u = edge[0];
    	       int v = edge[1];
    	       int wt = edge[2];
            
            
            if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
                return 1;
            }
        }
        
        
        return 0;
    }
}