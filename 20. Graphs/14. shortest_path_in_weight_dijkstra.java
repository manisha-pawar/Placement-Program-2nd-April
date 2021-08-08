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

    static class Pair implements Comparable < Pair > {
        int vtx;
        String psf;
        int wsf;

        Pair() {

        }

        Pair(int vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void dijkstra(ArrayList < Edge > [] graph, int src) {
        PriorityQueue < Pair > pq = new PriorityQueue < > ();
        boolean[] vis = new boolean[graph.length];

        pq.add(new Pair(src, src + "", 0));

        while (pq.size() > 0) {
            //remove
            Pair rem = pq.remove();

            //mark
            if (vis[rem.vtx] == true) {
                continue;
            }
            vis[rem.vtx] = true;

            //work
            System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);

            //add unvisited nbr
            for (Edge ne: graph[rem.vtx]) {

                if (vis[ne.nbr] == false) {
                    pq.add(new Pair(ne.nbr, rem.psf + ne.nbr, rem.wsf + ne.wt));
                }
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

        int src = Integer.parseInt(br.readLine());
        // write your code here
        dijkstra(graph, src);

    }
}