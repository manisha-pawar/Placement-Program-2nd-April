import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0; i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        System.out.println(singleTransc(prices));
    }
    
    public static int singleTransc(int[]prices) {
        int lmin = Integer.MAX_VALUE;
        int omax = Integer.MIN_VALUE;
        
        for(int i=0; i < prices.length;i++) {
            if(prices[i] < lmin) {
                lmin = prices[i];
            }
            
            int cp = prices[i] - lmin;
            
            if(cp > omax) {
                omax = cp;
            }
        }
        
        return omax;
    }

}