//https://www.lintcode.com/problem/434/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    
    static int[]par;
    static int[]rank;

    public List<Integer> numIslands2(int n, int m, Point[] operators) {

        List<Integer>ans = new ArrayList<>();

        if(operators == null || operators.length == 0) {
            return ans;
        }

        int[][]mat = new int[n][m];

        par = new int[n*m];
        rank = new int[n*m];

        for(int i=0; i < n*m;i++) {
            par[i] = i;
            rank[i] = 1;
        }

        int count = 0;

        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};


        for(int k=0; k < operators.length;k++) {
            int i = operators[k].x;
            int j = operators[k].y;

            if(mat[i][j] == 1) {
                ans.add(count);
                continue;
            }
            
            mat[i][j] = 1;
            count++;

            for(int d = 0; d < 4;d++) {
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    int sc = i * m + j; //source cell no.
                    int nc = ni * m + nj; //nbr cell no.

                    //union
                    int ls = find(sc); //leader of source
                    int ln = find(nc); //leader of nbr

                    if(ls != ln) {
                        //merging is posssible
                        if(rank[ls] < rank[ln]) {
                            par[ls] = ln;
                        }
                        else if(rank[ls] > rank[ln]) {
                            par[ln] = ls;
                        }
                        else {
                            par[ls] = ln;
                            rank[ln]++;
                        }
                        count--;
                    }
                    else {
                        //do nothing
                    }
                }
            }

            ans.add(count);
        }
        return ans;
    }


    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }
        else {
            int ans = find(par[x]);
            par[x] = ans; //path compression step
            return ans;
        }
    }
}