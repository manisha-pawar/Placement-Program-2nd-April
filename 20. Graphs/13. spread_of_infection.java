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

    public static int spread_of_infection(ArrayList < Edge > [] graph, int src, int time) {
        ArrayDeque < Integer > q = new ArrayDeque < > ();
        boolean[] vis = new boolean[graph.length];
        int ans = 0;
        int lev = 1;  //first person is infected at t = 1 

        q.add(src);

        while (q.size() > 0) {
            int count = q.size();

            if (lev > time) {
                break;
            }

            while (count-- > 0) {
                //remove
                int rem = q.remove();

                //mark*
                if (vis[rem] == true) {
                    continue;
                }
                vis[rem] = true;

                //work
                ans += 1;

                //add nbr
                for (Edge ne: graph[rem]) {
                    if (vis[ne.nbr] == false) {
                        q.add(ne.nbr);
                    }
                }
            }

            lev++;
        }

        return ans;
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
        int t = Integer.parseInt(br.readLine());

        // write your code here

        int ans = spread_of_infection(graph, src, t);
        System.out.println(ans);
    }

}