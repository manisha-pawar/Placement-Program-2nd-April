import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        conversion(exp);
    }

    public static void conversion(String exp) {
        Stack < Character > operator = new Stack < > ();
        Stack < String > prefix = new Stack < > ();
        Stack < String > postfix = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operator.push(ch);
            } 
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                //ch -> operand
                prefix.push(ch + "");
                postfix.push(ch + "");
            } 
            else if (ch == ')') {
                //evaluate till '('
                while (operator.peek() != '(') {
                    char opr = operator.pop();

                    //prefix evaluation
                    String prey = prefix.pop();
                    String prex = prefix.pop();
                    String prev = opr + prex + prey;

                    prefix.push(prev);

                    //postfix evaluation
                    String posty = postfix.pop();
                    String postx = postfix.pop();
                    String postv = postx + posty + opr;

                    postfix.push(postv);
                }
                operator.pop(); //  pop '('

            } 
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() > 0 && operator.peek() != '(' && priority(ch) <= priority(operator.peek())) {
                    char opr = operator.pop();

                    //prefix evaluation
                    String prey = prefix.pop();
                    String prex = prefix.pop();
                    String prev = opr + prex + prey;

                    prefix.push(prev);

                    //postfix evaluation
                    String posty = postfix.pop();
                    String postx = postfix.pop();
                    String postv = postx + posty + opr;

                    postfix.push(postv);
                }
                operator.push(ch);

            }
        }


        while (operator.size() > 0) {
            char opr = operator.pop();

            //prefix evaluation
            String prey = prefix.pop();
            String prex = prefix.pop();
            String prev = opr + prex + prey;

            prefix.push(prev);

            //postfix evaluation
            String posty = postfix.pop();
            String postx = postfix.pop();
            String postv = postx + posty + opr;

            postfix.push(postv);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }




    public static int priority(char opr) {
        if (opr == '+' || opr == '-') {
            return 1;
        } else if (opr == '*' || opr == '/') {
            return 2;
        } else {
            return -1;
        }
    }

}