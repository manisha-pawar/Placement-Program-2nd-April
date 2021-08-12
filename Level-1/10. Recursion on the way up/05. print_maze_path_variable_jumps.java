import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        printMazePaths(0,0,n-1,m-1,"");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        
        
        //horizontal
        for(int i=1; sc + i <= dc;i++) {
            printMazePaths(sr,sc + i,dr,dc,psf + 'h' + i);
        }
        
        //vertical 
        for(int i=1; sr + i <= dr;i++) {
            printMazePaths(sr + i,sc,dr,dc,psf + 'v' + i);
        }
        
        //diagonal
        for(int i=1; sr + i <= dr && sc + i <= dc ;i++) {
            printMazePaths(sr + i,sc + i,dr,dc, psf + 'd' + i);
        }
    }

}