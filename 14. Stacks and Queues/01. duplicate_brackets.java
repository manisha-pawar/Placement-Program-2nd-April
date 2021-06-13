import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        
        boolean isDB = duplicateBrackets(str);
        System.out.println(isDB);
    }
    
    public static boolean duplicateBrackets(String str) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < str.length();i++) {
            char ch = str.charAt(i);
            
            if(ch == '(') {
                st.push(ch);
            }
            else if(ch == ')') {
                int pc = 0;
                
                while(st.peek() != '(') {
                    pc++;
                    st.pop(); //to pop content between '(' , ')'
                }
                st.pop(); //to pop correspoding opening bracket
                
                if(pc == 0) {
                    //this pair of bracket is redundant
                    return true;
                }
            }
            else if(ch != ' '){
                //operator & operand
                st.push(ch);
            }
        }
        
        return false;
        
        
    }

}