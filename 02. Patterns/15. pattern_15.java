import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();

        int valc = 1;
        int spc = n / 2;
        int rst = 1;

        for (int r = 1; r <= n; r++) {
            //print spaces
            for (int i = 1; i <= spc; i++) {
                System.out.print("	");
            }

            //print values
            int val = rst;
            for (int i = 1; i <= valc; i++) {
                System.out.print(val + "	");

                if (i <= valc / 2) {
                    val++;
                } else {
                    val--;
                }
            }

            System.out.println();

            if (r <= n / 2) {
                spc--;
                valc += 2;
                rst++;
            } else {
                spc++;
                valc -= 2;
                rst--;
            }

        }

    }
}