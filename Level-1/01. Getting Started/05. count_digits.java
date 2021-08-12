import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int td = 0;

        while (n > 0) {
            n = n / 10;
            td++;
        }

        System.out.println(td);
    }
}