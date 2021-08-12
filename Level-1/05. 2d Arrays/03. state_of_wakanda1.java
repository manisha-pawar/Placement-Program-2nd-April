import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        columnTraversal(mat);
    }

    public static void columnTraversal(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;


        for (int c = 0; c < col; c++) {

            //even col -> top to down
            if (c % 2 == 0) {
                for (int r = 0; r < row; r++) {
                    System.out.println(mat[r][c]);
                }
            } else {
                //odd col -> down to top
                for (int r = row - 1; r >= 0; r--) {
                    System.out.println(mat[r][c]);
                }
            }

        }
    }

}