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

        exitPoint(mat);
    }

    public static void exitPoint(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int r = 0, c = 0;
        int dir = 0;

        //dir -> 0(east) , dir -> 1(south), dir -> 2(west), dir -> 3(north)

        while (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length) {

            dir = (mat[r][c] + dir) % 4;

            if (dir == 0) {
                //east -> right
                c++;

                if (c == col) {
                    c--;
                    break;
                }
            } else if (dir == 1) {
                //south -> down
                r++;

                if (r == row) {
                    r--;
                    break;
                }
            } else if (dir == 2) {
                //west -> left
                c--;

                if (c == -1) {
                    c++;
                    break;
                }
            } else {
                //north -> top
                r--;

                if (r == -1) {
                    r++;
                    break;
                }
            }
        }

        System.out.print(r + "\n" + c);

    }
}