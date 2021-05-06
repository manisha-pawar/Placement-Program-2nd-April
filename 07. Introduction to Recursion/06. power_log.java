import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        int ans = power(x,n);
        System.out.println(ans);
    }

    public static int power(int x, int n){
        if(n == 0) {
            return 1;    
        }
        
        int xrnb2 = power(x,n/2);
        int xrn = xrnb2 * xrnb2;
        
        if(n % 2 == 1) {
            //n is odd
            xrn = xrn * x;
        }
        
        return xrn;
    }

}