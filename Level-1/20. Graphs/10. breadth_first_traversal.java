import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vtx;
        String psf;

        Pair() {

        }

        Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }



    //normal breadth first traversal
    public static void bfs(ArrayList < Edge > [] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        ArrayDeque < Pair > q = new ArrayDeque < > ();

        q.add(new Pair(src, src + ""));

        while (q.size() > 0) {
            //remove
            Pair rem = q.remove();

            //mark*
            if (vis[rem.vtx] == true) {
                continue;
            }

            vis[rem.vtx] = true;

            //work
            System.out.println(rem.vtx + "@" + rem.psf);

            //add unvisited nbr
            for (Edge ne: graph[rem.vtx]) {
                int nbr = ne.nbr;
                if (vis[nbr] == false) {
                    q.add(new Pair(nbr, rem.psf + nbr));
                }
            }
        }
    }




    //level-wise breadth first traversal
    public static void bfs_lw(ArrayList < Edge > [] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        ArrayDeque < Integer > q = new ArrayDeque < > ();

        q.add(src);
        int lev = 0;

        while (q.size() > 0) {
            int count = q.size();
            System.out.print(lev + " -> ");

            while (count-- > 0) {
                //remove
                int rem = q.remove();

                //mark*
                if (vis[rem] == true) {
                    continue;
                }
                vis[rem] = true;

                //work
                System.out.print(rem + " ");

                //add unvisited nbr
                for (Edge ne: graph[rem]) {
                    if (vis[ne.nbr] == false) {
                        q.add(ne.nbr);
                    }
                }
            }


            lev++;
            System.out.println();
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here  
        bfs(graph, src);
    }
}