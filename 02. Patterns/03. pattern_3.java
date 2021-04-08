import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // //1. row work splitting

        // int spc = n - 1;
        // int stc = 1;

        // for(int r = 1; r <= n ;r++) {
        //     //print spaces
        //     for(int i=1; i <= spc;i++) {
        //         System.out.print("	");
        //     }

        //     //print stars
        //     for(int i=1; i <= stc;i++) {
        //         System.out.print("*	");
        //     }

        //     System.out.println();
        //     spc--;
        //     stc++;
        // }


        //2. relation between r & c

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {

                if (r + c >= n + 1) {
                    System.out.print("*	");
                } else if (r + c < n + 1) {
                    System.out.print("	");
                }
            }
            System.out.println();
        }
    }
}