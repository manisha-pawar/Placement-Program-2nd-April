import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        int count = islands(arr);
        System.out.println(count);
    }

    public static int islands(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        //0 -> land, 1 -> water
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                //valid unvisited vertex -> an unvisited 0
                if (mat[i][j] == 0 && vis[i][j] == false) {
                    count++;
                    dfs(i, j, mat, vis);
                }

            }
        }

        return count;
    }


    static int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    
    public static void dfs(int sr, int sc, int[][] mat, boolean[][] vis) {
        vis[sr][sc] = true;

        for (int i = 0; i < dir.length; i++) {
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];

            if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && mat[nr][nc] == 0 && vis[nr][nc] == false) {
                dfs(nr, nc, mat, vis);
            }
        }
    }



}