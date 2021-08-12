import java.io.*;
import java.util.*;

public class Main {

    static int count = 0;
    public static int perfect_friends(ArrayList < Integer > [] graph) {
        ArrayList < Integer > ccs = new ArrayList < > ();
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false) {
                count = 0;
                dfs(i, graph, vis);
                ccs.add(count);
            }
        }

        int ways = 0;

        for (int i = 0; i < ccs.size(); i++) {
            for (int j = i + 1; j < ccs.size(); j++) {
                int s1 = ccs.get(i); //ith comp size
                int s2 = ccs.get(j); //jth comp size

                ways += s1 * s2;
            }
        }

        return ways;
    }

    public static void dfs(int src, ArrayList < Integer > [] graph, boolean[] vis) {
        vis[src] = true;

        //work
        count++;

        for (int nbr: graph[src]) {
            if (vis[nbr] == false) {
                dfs(nbr, graph, vis);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here

        ArrayList < Integer > [] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (k-- > 0) {
            String input = br.readLine();
            String[] arr = input.split(" ");

            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);

            graph[u].add(v);
            graph[v].add(u);

        }

        int ways = perfect_friends(graph);
        System.out.println(ways);
    }

}