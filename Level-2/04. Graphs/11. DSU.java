public class Main {
    static int[]par;
    static int[]rank;

    public static void main(String[]args) {
        int[][]relations = {{1,2},{4,5},{2,6},{3,7},{9,10},{6,8},{3,5},{10,11},{4,8}};

        int n = 11;

        //name : 1 to n
        par = new int[n+1];
        rank = new int[n+1];

        for(int i=1; i <= n;i++) {
            par[i] = i;
            rank[i] = 0;
        }

        for(int i=0; i < relations.length;i++) {
            int x = relations[i][0];
            int y = relations[i][1];

            union(x,y);
        }

        int gc = 0;

        //find number of groups
        for(int i=1; i <= n;i++) {
            if(par[i] == i) {
                //i is a set leader
                gc++;
            }
        }

        System.out.println(gc);
    }

    public static void union(int x,int y) {
        int lx = find(x);
        int ly = find(y);

        //merging
        if(lx != ly) {
            if(rank[lx] < rank[ly]) {
                par[lx] = ly;
            }
            else if(rank[lx] > rank[ly]) {
                par[ly] = lx;
            }
            else {
                par[lx] = ly;
                rank[ly]++;
            }
        }
    }

    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }
        else {
            int ans = find(par[x]);
            par[x] = ans; //path compression 
            return ans;
        }
    }
}