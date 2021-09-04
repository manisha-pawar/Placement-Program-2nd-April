import java.io.*;
import java.util.*;

public class Main {

    //mrlsf -> min removal left so far
    public static void solution(String str, int mrlsf, HashSet < String > hs) {

        if (mrlsf == 0) {
            if (getMin(str) == 0) {
                if (hs.contains(str) == false) {
                    System.out.println(str);
                    hs.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String ros = str.substring(0, i) + str.substring(i + 1);
            solution(ros, mrlsf - 1, hs);
        }

    }

    public static int getMin(String str) {

        Stack < Character > st = new Stack < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0 || st.peek() == ')') {
                    st.push(ch);
                } else {
                    st.pop();
                }
            }
        }

        return st.size();
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet < > ());
    }

}