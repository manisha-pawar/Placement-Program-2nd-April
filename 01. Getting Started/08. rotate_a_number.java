import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int temp = n, d = 0;

        //count of digits
        while (temp > 0) {
            temp = temp / 10;
            d++;
        }

        k = k % d;

        if (k < 0) {
            k = k + d;
        }

        int p1 = (int) Math.pow(10, k);
        int a = n / p1;
        int b = n % p1;

        int p2 = (int) Math.pow(10, d - k);
        int ans = b * p2 + a;

        System.out.println(ans);
    }
}