import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();

        int spc = 2 * n - 3;

        for (int r = 1; r <= n; r++) {
            //print left values
            int lv = 1;
            for (int i = 1; i <= r; i++) {
                System.out.print(lv + "	");
                lv++;
            }

            //print spaces
            for (int i = 1; i <= spc; i++) {
                System.out.print("	");
            }

            //print right values
            int rcnt = (r == n) ? r - 1 : r;
            int rv = rcnt;
            for (int i = 1; i <= rcnt; i++) {
                System.out.print(rv + "	");
                rv--;
            }

            System.out.println();
            spc -= 2;
        }

    }
}