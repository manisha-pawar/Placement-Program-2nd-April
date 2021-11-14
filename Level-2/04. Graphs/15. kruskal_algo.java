import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }

        System.out.println(minCostToSupplyWater(v, edges));
    }

    static int[] parent;
    static int[] rank;

    public static class Pair implements Comparable < Pair > {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int minCostToSupplyWater(int n, int[][] pipes) {
        //sort the array of edges
        Pair[] arr = new Pair[pipes.length];

        for (int i = 0; i < pipes.length; i++) {
            arr[i] = new Pair(pipes[i][0], pipes[i][1], pipes[i][2]);
        }

        Arrays.sort(arr);


        //apply dsu
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int cost = 0;
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i].u;
            int v = arr[i].v;
            int wt = arr[i].wt;


            int lu = find(u);
            int lv = find(v);

            if (lu != lv) {
                cost += wt;

                if (rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                } else if (rank[lu] > rank[lv]) {
                    parent[lv] = lu;
                } else {
                    parent[lu] = lv;
                    rank[lv]++;
                }
            }

        }
        return cost;
    }


    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            int ans = find(parent[x]);
            parent[x] = ans; //path compression

            return ans;
        }
    }

}