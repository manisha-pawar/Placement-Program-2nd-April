import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code

        int val = 1;
        Stack < Integer > st = new Stack < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                st.push(val);
                val++;
            } else {
                st.push(val);
                val++;

                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }

        st.push(val);

        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}