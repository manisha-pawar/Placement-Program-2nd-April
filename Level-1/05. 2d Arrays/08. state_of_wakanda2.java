import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][]mat = new int[n][n];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < n;j++) {
                mat[i][j]=scn.nextInt();
            }
        }
        
        printDiagonally(mat);
    }
    
    public static void printDiagonally(int[][]mat) {
        int n = mat.length;
        
        //to select diagonal
        for(int d=0 ; d < n; d++) {
            //print dth diagonal
            for(int r=0,c=d; c < n;r++,c++) {
                System.out.println(mat[r][c]);
            }
        }
    }

}