import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        //write your code here

        colB = new boolean[n];
        regDB = new boolean[2 * n - 1];
        revDB = new boolean[2 * n - 1];

        nqueens(0, board, "");
    }

    static boolean[] colB;
    static boolean[] regDB;
    static boolean[] revDB;

    public static void nqueens(int row, boolean[][] chess, String asf) {
        if (row == chess.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            int regdn = row + col;
            int revdn = row - col + (chess.length - 1);

            if (colB[col] == false && regDB[regdn] == false && revDB[revdn] == false) {
                chess[row][col] = true;
                colB[col] = true;
                regDB[regdn] = true;
                revDB[revdn] = true;

                nqueens(row + 1, chess, asf + row + "-" + col + ", ");

                chess[row][col] = false;
                colB[col] = false;
                regDB[regdn] = false;
                revDB[revdn] = false;
            }
        }
    }

}