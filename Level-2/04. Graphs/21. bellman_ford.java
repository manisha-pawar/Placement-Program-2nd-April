import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static class Edge {
        int u;
        int v;
        int wt;
        
        Edge() {
            
        }
        
        Edge(int u,int v,int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        
        int vtx = scn.nextInt();
        int edges = scn.nextInt();
        
        ArrayList<Edge>[]graph = new ArrayList[vtx];
        
        for(int i=0; i < vtx;i++) {
            graph[i] = new ArrayList<>();
        }
        
        while(edges-- > 0) {
            int u = scn.nextInt(); u--;
            int v = scn.nextInt(); v--;
            int wt = scn.nextInt();
            
            Edge edge = new Edge(u,v,wt);
            graph[u].add(edge);
        }
        
        int[]mincost = bellmanford(graph,0);
        
        for(int i=1; i < graph.length;i++) {
            System.out.print(mincost[i] + " ");
        }
	}
	
	
	public static int[] bellmanford(ArrayList<Edge>[]graph,int src) {
	    int[]path = new int[graph.length];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[src] = 0;
	   
	    
	    ArrayList<Edge>edges = new ArrayList<>();
	    
	    for(int i=0; i < graph.length;i++) {
	        for(Edge edge : graph[i]) {
	            edges.add(edge);
	        }
	    }
	    
	    
	    for(int itr = 1; itr <= graph.length-1;itr++) {
	        for(Edge edge : edges) {
	            int u = edge.u;
	            int v = edge.v;
	            int wt = edge.wt;
	            
	            
	            if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
	                path[v] = path[u] + wt;
	            }
	        }
	    }
	    
	    return path;
	}

}
