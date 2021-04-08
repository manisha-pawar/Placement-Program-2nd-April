import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        boolean isPT = false;

        if (a * a == b * b + c * c) {
            //a is hypotenuse
            isPT = true;
        } else if (b * b == a * a + c * c) {
            //b is hypotenuse
            isPT = true;
        } else if (c * c == a * a + b * b) {
            //c is hyoptenuse
            isPT = true;
        }

        System.out.println(isPT);
    }
}