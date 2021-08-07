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

    static class Pair {
        int vtx;
        int sn; //set number

        Pair() {

        }

        Pair(int vtx, int sn) {
            this.vtx = vtx;
            this.sn = sn;
        }
    }


    public static boolean singleCompBipartite(ArrayList < Edge > [] graph, int src, int[] vis) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();

        q.add(new Pair(src, 1));

        while (q.size() > 0) {
            //remove
            Pair rem = q.remove();

            //mark*
            if (vis[rem.vtx] != 0) {
                //check
                int osn = vis[rem.vtx];
                int psn = rem.sn;

                if (osn != psn) {
                    return false;
                } else {
                    continue;
                }
            }
            vis[rem.vtx] = rem.sn;

            //add unvisited nbr
            for (Edge ne: graph[rem.vtx]) {
                int nbr = ne.nbr;

                if (vis[nbr] == 0) {
                    int nsn = (rem.sn == 1) ? 2 : 1; //nbr set number

                    q.add(new Pair(nbr, nsn));
                }

            }
        }

        return true;

    }

    public static boolean isGraphBipartite(ArrayList < Edge > [] graph) {
        int[] vis = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                boolean sca = singleCompBipartite(graph, i, vis); //single comp ans

                if (sca == false) {
                    return false;
                }
            }
        }

        return true;
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

        // write your code here
        boolean ans = isGraphBipartite(graph);
        System.out.println(ans);
    }
}