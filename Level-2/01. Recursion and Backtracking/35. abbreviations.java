import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count, int idx){
        if(idx == str.length()) {
            if(count == 0) {
                System.out.println(asf);
            }
            else {
                System.out.println(asf + count);
            }
            return;
        }
        
        char ch = str.charAt(idx);
        
        //yes
        if(count > 0) {
            solution(str,asf + count + ch ,0,idx+1);
        }
        else if(count == 0){
            solution(str,asf + ch,0,idx+1);
        }
        
        //no 
        solution(str,asf, count + 1,idx+1);
        
    }

    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
}