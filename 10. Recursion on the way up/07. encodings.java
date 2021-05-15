import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        
        if(ch == '0') {
            return;
        }
        
        //single 
        String ros = str.substring(1);
        char enc = (char)(ch - '0' - 1 + 'a');
        printEncodings(ros,asf + enc);
        
        //clubbing of two chars
        if(str.length() >= 2) {
            int tp = str.charAt(0) - '0';
            int up = str.charAt(1) - '0';
            
            int val = tp*10 + up;
            
            if(val >= 10 && val <= 26) {
                String ros2 = str.substring(2);
                char enc2 = (char)(val - 1 + 'a');
                printEncodings(ros2,asf + enc2);
            }
        }
         
    }

}