import java.util.*;

public class Main {
    
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        
        placeQueens(0,"",N);
    }
    
    public static void placeQueens(int r,String psf,int N) {
        if(r == N) {
            System.out.println(psf);
            return;
        }
        
        //place queen at any col in my row
        for(int c = 0; c < N;c++) {
            placeQueens(r+1, psf + r + c +"-",N);
        }
    }
}