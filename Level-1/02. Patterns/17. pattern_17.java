import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();

        int rstc = 1;

        for (int r = 1; r <= n; r++) {
            //print spaces
            int spc = (r == (n + 1) / 2) ? 0 : n / 2;
            for (int i = 1; i <= spc; i++) {
                System.out.print("	");
            }

            //print left stars
            int lstc = (r == (n + 1) / 2) ? n / 2 : 0;
            for (int i = 1; i <= lstc; i++) {
                System.out.print("*	");
            }

            //print right stars
            for (int i = 1; i <= rstc; i++) {
                System.out.print("*	");
            }

            System.out.println();

            if (r <= n / 2) {
                rstc++;
            } else {
                rstc--;
            }

        }

    }
}