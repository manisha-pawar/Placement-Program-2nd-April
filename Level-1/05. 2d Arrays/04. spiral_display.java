import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m  = scn.nextInt();
        
        int[][]mat = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0;j < m;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        spiralDisplay(mat);
        
    }
    
    public static void spiralDisplay(int[][]a) {
        
        int rs = 0;
        int cs = 0;
        int re = a.length - 1;
        int ce = a[0].length - 1;
        int te = a.length * a[0].length;
        
        int count = 0;
        
        while(count < te) {
        //single shell printing
        
            //left wall
            for(int i=rs; i <= re && count < te;i++) {
                System.out.println(a[i][cs]);
                count++;
            }
            cs++;
            
            //bottom wall
            for(int j=cs; j <= ce && count < te;j++) {
                System.out.println(a[re][j]);
                count++;
            }
            re--;
            
            //right wall
            for(int i = re ; i >= rs && count < te;i--) {
                System.out.println(a[i][ce]);
                count++;
            }
            ce--;
            
            //top wall
            for(int j=ce; j >= cs && count < te;j--) {
                System.out.println(a[rs][j]);
                count++;
            }
            rs++;
        }
    }
    
}