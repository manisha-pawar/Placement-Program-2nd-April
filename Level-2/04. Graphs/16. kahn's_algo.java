import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int e = scn.nextInt();

        ArrayList < Integer > [] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (e-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph[u].add(v); //directed graph
        }

        kahn(graph);
    }

    public static void kahn(ArrayList < Integer > [] graph) {
        int[] indegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int nbr: graph[i]) {
                indegree[nbr]++;
            }
        }

        ArrayDeque < Integer > q = new ArrayDeque < > ();
        ArrayList < Integer > ts = new ArrayList < > ();

        //add those vertices which have 0 indegree

        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.size() > 0) {
            int rem = q.remove();
            ts.add(rem);

            for (int nbr: graph[rem]) {
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }


        for (int i = 0; i < ts.size(); i++) {
            System.out.println(ts.get(i));
        }
    }

}