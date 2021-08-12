import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn  = new Scanner(System.in);
        String str = scn.next();
        System.out.println(countEncodings(str));
    }
    
    public static int countEncodings(String str) {
        if(str.charAt(0) == '0') {
            return 0;
        }
        
        str = '.' + str;
        int[]dp = new int[str.length()];
        
        //dp[i] -> str.substring(0,i) ke total encodings
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i < str.length();i++) {
            char c = str.charAt(i); //ith character
            char p  = str.charAt(i-1); //i-1 th character
            
            if(c == '0' && p == '0') {
                dp[i] = 0;
            }
            else if(p == '0') {
                dp[i] = dp[i-1];
            }
            else if(c == '0') {
                if(p == '1' || p == '2') {
                    dp[i] = dp[i-2];
                }
            }
            else {
                dp[i] = dp[i-1];
                
                int num = (p-'0')*10 + (c-'0');
                
                if(num <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        
        return dp[str.length()-1];
    }
}