import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][]mat = new int[n][n];
        
        for(int i=0; i < n;i++) {
            for(int j=0;j < n;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        int sp = saddlePoint(mat);
        
        if(sp == -1) {
            System.out.println("Invalid input");
        }
        else {
            System.out.println(sp);
        }
    
    }
    
    public static int saddlePoint(int[][]mat) {
        
        int n = mat.length;
        
        for(int r = 0; r < n;r++) {
            
            //find min element and its col in rth row
            int minc = 0;
            int minv = mat[r][0];
            
            for(int c = 1; c < n;c++) {
                if(mat[r][c] < minv) {
                    minv = mat[r][c];
                    minc = c;
                }
            }
            
            
            //minv is the maximum value in minc
            boolean isSP = true;
            for(int i=0; i < n;i++) {
                if(mat[i][minc] > minv) {
                    isSP = false;
                    break;
                }
            }
            
            if(isSP == true) {
                return minv;
            }
            
        }
        
        return -1;
    }   

}