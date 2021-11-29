//https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1

class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[]degree = new int[V];
        int ed = 0;
        int od = 0;
        
        for(int i=0; i < V;i++) {
            degree[i] = adj.get(i).size();
            
            if(degree[i] % 2 == 0) {
                ed++;
            }
            else {
                od++;
            }
        }
        
        if(od == 0) {
            //all vertices have even degree
            return 2;
        }
        else if(od == 2) {
            //two vertices have odd degree, rest of the vertices have even degree
            return 1;
        }
        else {
            return 0;
        }
        
        
    }
}