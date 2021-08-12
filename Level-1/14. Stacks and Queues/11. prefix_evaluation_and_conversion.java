import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        evalAndConvert(exp);
    }

    public static void evalAndConvert(String exp) {

        Stack < Integer > eval = new Stack < > ();
        Stack < String > infix = new Stack < > ();
        Stack < String > postfix = new Stack < > ();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                char opr = ch;

                //value evaluation
                int vx = eval.pop();
                int vy = eval.pop();

                int val = calculate(vx, vy, opr);
                eval.push(val);

                //infix conversion
                String inx = infix.pop();
                String iny = infix.pop();

                String inval = "(" + inx + opr + iny + ")";
                infix.push(inval);

                //postfix conversion
                String postx = postfix.pop();
                String posty = postfix.pop();

                String postval = postx + posty + opr;
                postfix.push(postval);
            }
        }

        System.out.println(eval.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }

    public static int calculate(int a, int b, char opr) {
        if (opr == '+') {
            return a + b;
        } else if (opr == '-') {
            return a - b;
        } else if (opr == '*') {
            return a * b;
        } else if (opr == '/') {
            return a / b;
        } else {
            return -1;
        }
    }
}