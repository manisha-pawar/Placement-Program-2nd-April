import java.util.*;

public class Main {
    
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        
        placeQueens(0,"",0,N);
    }
    
    public static void placeQueens(int b,String psf,int qpsf,int N) {
        if(b == N*N) {
            if(qpsf == N) {
                System.out.println(psf + "->" + qpsf);
            }
            return;
        }
        
        //b -> yes choice (queen should be placed here)
        placeQueens(b+1,psf + b + " ",qpsf + 1,N);
        
        //b -> no choice (queen should not be placed here)
        placeQueens(b+1,psf,qpsf,N);
    }
}