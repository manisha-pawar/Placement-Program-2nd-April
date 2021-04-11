import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //1. row work splitting
        
        int spc = n/2;
        int stc = 1;
        
        for(int r = 1; r <= n;r++) {
            //print spaces
            for(int i=1; i <= spc;i++) {
                System.out.print("	");
            }
            
            //print stars
            for(int i=1; i <= stc;i++) {
                System.out.print("*	");
            }
            
            System.out.println();
            
            if(r <= n/2) {
                spc--;
                stc+=2;
            }
            else if(r > n/2) {
                spc++;
                stc-=2;
            }
        }

        // //2. relation between r & c
        
        // for(int r = 1; r <= n ;r++) {
        //     for(int c = 1; c <= n;c++) {
        //         if(r + c < (n + 3) / 2) {
        //             System.out.print("	");
        //         }
        //         else if(c - r > (n - 1) / 2) {
        //             System.out.print("	");
        //         }
        //         else if(r + c > (3*n + 1)/2) {
        //             System.out.print("	");
        //         }
        //         else if(r - c > (n - 1)/2) {
        //             System.out.print("	");
        //         }
        //         else {
        //             System.out.print("*	");
        //         }
        //     }
            
        //     System.out.println();
        // }

    }
}