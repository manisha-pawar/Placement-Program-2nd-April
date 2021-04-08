import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        for(int r = 1; r <= n; r++) {
            //work
            for(int i = 1; i <= r;i++) {
                System.out.print("*	");
            }
            System.out.println();
        }

    }
}