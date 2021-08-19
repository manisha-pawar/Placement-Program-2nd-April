import java.io.*;
import java.util.*;

public class Main {

    public static boolean isQueenSafe(int[][] chess, int row, int col) {
        int[][]dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{-1,1},{1,1}};
        
        for(int k=0; k < 8;k++) {
            for(int i = row + dir[k][0], j = col + dir[k][1]; i >= 0 && i < chess.length && j >= 0 && j < chess[0].length;) {
                if(chess[i][j] != 0) {
                    return false;
                }
                i += dir[k][0];
                j += dir[k][1];
            }
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int N, int[][] chess) {
        // write your code here
        if(qpsf == N) {
            for(int i=0; i < N;i++) {
                for(int j=0; j < N;j++) {
                    if(chess[i][j] == 0) {
                        System.out.print("-\t");
                    }
                    else {
                        System.out.print("q"  + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int b = 0; b < N*N ; b++) {
            int i = b / N;
            int j = b % N;
            
            if(chess[i][j] == 0 && isQueenSafe(chess,i,j) == true) {
                chess[i][j] = qpsf+1;
                nqueens(qpsf+1,N,chess);
                chess[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}