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
        Stack < String > prefix = new Stack < > ();


        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                char opr = ch;

                //value stack
                int vy = eval.pop();
                int vx = eval.pop();

                int val = calculate(vx, vy, opr);
                eval.push(val);

                //infix stack
                String iny = infix.pop();
                String inx = infix.pop();

                String inval = "(" + inx + opr + iny + ")";
                infix.push(inval);


                //prefix stack
                String prey = prefix.pop();
                String prex = prefix.pop();

                String preval = opr + prex + prey;
                prefix.push(preval);
            }
        }


        System.out.println(eval.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());


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