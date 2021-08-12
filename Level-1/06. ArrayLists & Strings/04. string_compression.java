import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		// write your code here
    
        String c1 = "";
        
        for(int i=0; i < str.length()-1; i++) {
            if(str.charAt(i) != str.charAt(i+1)) {
                c1 = c1  + str.charAt(i);
            }
        }
        
        int li = str.length()-1;
        c1 = c1 + str.charAt(li);
        
		return c1;
	}

	public static String compression2(String str){
		// write your code here
        
        String c2 = "";
        
        int c = 1;
        
        for(int i=0; i < str.length()-1;i++) {
            if(str.charAt(i) != str.charAt(i+1)) {
                c2 += str.charAt(i);
                if(c > 1) {
                    c2 += c;
                }
                c = 1;
            }
            else {
                c++;
            }
        }
        
        int li = str.length()-1;
        c2 += str.charAt(li);
        if(c > 1) {
            c2 += c;
        }
        
		return c2;
	}
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}