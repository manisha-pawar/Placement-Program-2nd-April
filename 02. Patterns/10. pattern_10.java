import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        int lspc = n / 2;
        int mspc = -1;


        for (int r = 1; r <= n; r++) {
            //print left spaces
            for (int i = 1; i <= lspc; i++) {
                System.out.print("	");
            }

            //print left star
            System.out.print("*	");

            //print middle spaces
            for (int i = 1; i <= mspc; i++) {
                System.out.print("	");
            }

            //print right star
            if (r != 1 && r != n) {
                System.out.print("*	");
            }

            System.out.println();

            if (r <= n / 2) {
                lspc--;
                mspc += 2;
            } else {
                lspc++;
                mspc -= 2;
            }
        }

    }
}