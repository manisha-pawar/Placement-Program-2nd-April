import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int d = 0, temp = n;

        while (temp > 0) {
            temp = temp / 10;
            d++;
        }

        int pow = (int) Math.pow(10, d - 1);

        while (pow > 0) {
            int ld = n / pow;
            n = n % pow;

            System.out.println(ld);
            pow = pow / 10;
        }

    }
}