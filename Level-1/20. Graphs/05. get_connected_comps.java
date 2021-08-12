import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static ArrayList < ArrayList < Integer >> getConnectedComp(ArrayList < Edge > [] graph) {
        ArrayList < ArrayList < Integer >> cc = new ArrayList < > ();

        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false) {
                ArrayList < Integer > scc = new ArrayList < > ();
                singleConnectedComp(i, graph, scc, vis);
                cc.add(scc);
            }
        }

        return cc;
    }


    public static void singleConnectedComp(int src, ArrayList < Edge > [] graph, ArrayList < Integer > comp, boolean[] vis) {
        vis[src] = true;

        comp.add(src);

        for (Edge ne: graph[src]) {
            int nbr = ne.nbr;

            if (vis[nbr] == false) {
                singleConnectedComp(nbr, graph, comp, vis);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList < ArrayList < Integer >> comps = getConnectedComp(graph);

        // write your code here

        System.out.println(comps);
    }

}