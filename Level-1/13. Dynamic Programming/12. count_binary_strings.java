import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ans = cbs(n);
        System.out.println(ans);
    }

    public static int cbs(int n) {
        int oetz = 1; //old ending at zero
        int oeto = 1; //old ending at one

        for (int i = 2; i <= n; i++) {
            int netz = oeto; //new ending at zero
            int neto = oetz + oeto; //new ending at one

            oeto = neto;
            oetz = netz;
        }

        return oeto + oetz;
    }

}