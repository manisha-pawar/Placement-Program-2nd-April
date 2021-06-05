import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(count(str));
    }
    
    public static int count(String str) {
        
        int a = 0; //a+
        int ab = 0; //a+b+
        int abc = 0; //a+b+c+
        
        for(int i=0; i < str.length();i++) {
            char ch = str.charAt(i);
            
            if(ch == 'a') {
                //a+
                a = 2*a + 1;
            }
            else if(ch == 'b') {
                //a+b+
                ab = a + 2*ab;
            }
            else if(ch == 'c') {
                //a+b+c+
                abc = ab + 2*abc;
            }
            else {
                //nothing
            }
        }
        
        return abc;
    }
}