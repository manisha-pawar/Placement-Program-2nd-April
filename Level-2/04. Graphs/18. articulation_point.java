import java.util.*;
import java.io.*;

class Main {

    static int[] disc;
    static int[] low;
    static boolean[] ap;
    static int temp; //count of unvisited nbr calls for initial src
    static int time;


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int vtx = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList < Integer > [] graph = new ArrayList[vtx];

        for (int i = 0; i < vtx; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (edges-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            u--;
            v--;

            graph[u].add(v);
            graph[v].add(u);
        }


        boolean[] vis = new boolean[graph.length];
        disc = new int[graph.length];
        low = new int[graph.length];
        time = 0;
        ap = new boolean[graph.length];
        temp = 0;

        articulation_point(graph, 0, -1, vis);

        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if (ap[i] == true) {
                count++;
            }
        }

        System.out.println(count);
    }



    public static void articulation_point(ArrayList < Integer > [] graph, int src, int par, boolean[] vis) {

        vis[src] = true;
        disc[src] = low[src] = time;
        time++;


        for (int nbr: graph[src]) {
            if (nbr == par) {
                //ignore
            } else if (vis[nbr] == false) {
                articulation_point(graph, nbr, src, vis);
                low[src] = Math.min(low[src], low[nbr]);

                if (src == 0) {
                    temp++;

                    if (temp > 1) {
                        ap[src] = true;
                    }
                }
            } else if (vis[nbr] == true) {
                low[src] = Math.min(low[src], disc[nbr]);
            }

            if (src != 0 && disc[src] <= low[nbr]) {
                ap[src] = true;
            }


        }
    }

}