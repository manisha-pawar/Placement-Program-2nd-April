import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        int val = infix_evaluation(exp);
        System.out.println(val);
    }

    public static int infix_evaluation(String exp) {
        Stack < Integer > operand = new Stack < > ();
        Stack < Character > operator = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operator.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                //ch -> operand
                operand.push(ch - '0');
            } else if (ch == ')') {
                //evaluate till opening bracket
                while (operator.peek() != '(') {
                    char opr = operator.pop();
                    int b = operand.pop();
                    int a = operand.pop();

                    int val = calculate(a, b, opr);
                    operand.push(val);
                }
                operator.pop(); //pop '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //ch -> operator
                while (operator.size() > 0 && operator.peek() != '(' && priority(ch) <= priority(operator.peek())) {
                    char opr = operator.pop();
                    int b = operand.pop();
                    int a = operand.pop();

                    int val = calculate(a, b, opr);
                    operand.push(val);
                }
                operator.push(ch);
            }

        }


        while (operator.size() > 0) {
            char opr = operator.pop();
            int b = operand.pop();
            int a = operand.pop();

            int val = calculate(a, b, opr);
            operand.push(val);
        }


        return operand.peek();
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