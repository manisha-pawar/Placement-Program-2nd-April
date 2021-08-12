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
        
        System.out.println(infiniteTranscn(prices));
    }
    
    public static int infiniteTranscn(int[]prices) {
        
        int opr = 0;
        
        for(int i=0; i < prices.length-1 ;i++) {
            
            if(prices[i] < prices[i+1]) {
                opr += prices[i+1] - prices[i];
            }
        }
        
        return opr;
    }

}