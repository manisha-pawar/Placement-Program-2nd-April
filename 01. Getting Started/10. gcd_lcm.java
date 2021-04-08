import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        //to calculate gcd
        int gcd = 0;
        int dividend = n1;
        int divisor = n2;

        while (dividend % divisor != 0) {
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }

        gcd = divisor;

        int lcm = (n1 * n2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}