import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        
        boolean isBal = balanced(exp);
        System.out.println(isBal);
    }
    
    public static boolean balanced(String exp) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < exp.length();i++) {
            char ch = exp.charAt(i);
            
            //opening bracket
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']') {
                if(st.size() == 0) {
                    //this closing bracket is not able to find its opening bracket
                    return false;
                }
                char cop = corrOB(ch);
                if(st.peek() != cop) {
                    //due to mismatch
                    return false;
                }
                st.pop(); //to pop opening bracket
            }
        }
        
        if(st.size() > 0) {
            //due to extra opening bracket
            return false;
        }
        else {
            return true;
        }
        
    }
    
    public static char corrOB(char cb) {
        if(cb == ')') {
            return '(';
        }
        else if(cb == '}') {
            return '{';
        }
        else {
            return '[';
        }
    }
    

}