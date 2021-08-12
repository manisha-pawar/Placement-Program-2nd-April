import java.util.*;

public class Main {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge() {

        }

        Edge(int src,int nbr,int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int vtx = scn.nextInt(); //total vertices
        int e = scn.nextInt(); //total edges

        ArrayList<Edge>[]graph = new ArrayList[vtx];
        for(int i=0; i < graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        while(e-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            addEdge(graph,u,v,wt);
        }

        display(graph);
    }

    public static void display(ArrayList<Edge>[]graph) {
        for(int i = 0; i < graph.length;i++) {
            System.out.print(i + " -> ");
            for(Edge ne : graph[i]) {
                int src = i;
                int nbr = ne.nbr;
                int wt = ne.wt;

                System.out.print(src + " - " + nbr + " @ " + wt + ", ");
            }
            System.out.println();
        }
    }

    public static void addEdge(ArrayList<Edge>[]graph,int u,int v,int wt) {
        Edge e1 = new Edge(u,v,wt);
        Edge e2 = new Edge(v,u,wt);

        graph[u].add(e1);
        graph[v].add(e2);
    }
}