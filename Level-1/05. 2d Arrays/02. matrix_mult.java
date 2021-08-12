import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int r1 = scn.nextInt();
        int c1 = scn.nextInt();

        int[][] mat1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                mat1[i][j] = scn.nextInt();
            }
        }

        int r2 = scn.nextInt();
        int c2 = scn.nextInt();

        int[][] mat2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                mat2[i][j] = scn.nextInt();
            }
        }

        matrixMult(mat1, mat2);
    }

    public static void matrixMult(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;

        if (c1 != r2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] prod = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                //select ith row from A and jth col from B
                int res = 0;
                for (int k = 0; k < c1; k++) {
                    res += A[i][k] * B[k][j];
                }
                prod[i][j] = res;
            }
        }


        //print product matrix
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(prod[i][j] + " ");
            }
            System.out.println();
        }
    }

}