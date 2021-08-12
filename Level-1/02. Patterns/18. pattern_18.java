import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {

                if (r == 1 || r == c || r + c == n + 1) {
                    System.out.print("*	");
                } else if (r > (n + 1) / 2 && r > c && r + c > n + 1) {
                    System.out.print("*	");
                } else {
                    System.out.print("	");
                }

            }

            System.out.println();
        }

    }
}