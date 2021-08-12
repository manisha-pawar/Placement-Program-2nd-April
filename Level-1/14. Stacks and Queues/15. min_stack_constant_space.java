import java.io.*;
import java.util.*;

public class Main {

    public static class MinStack {
        Stack < Integer > data;
        int min;

        public MinStack() {
            data = new Stack < > ();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else {
                if (val < min) {
                    //push fake value
                    int fval = val + (val - min);
                    data.push(fval);
                    min = val;
                } else {
                    //push real value
                    data.push(val);
                }
            }
        }

        int pop() {
            if (data.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                if (data.peek() < min) {
                    //data.peek() -> fake value
                    int rval = min;
                    int omin = rval + rval - data.pop();
                    min = omin;
                    return rval;
                } else {
                    //data.peek() -> real value
                    return data.pop();
                }
            }
        }

        int top() {
            if (data.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                if (data.peek() < min) {
                    //data.peek() -> fake value
                    return min;
                } else {
                    //data.peek() -> real value
                    return data.peek();
                }
            }
        }

        int min() {
            if (data.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}