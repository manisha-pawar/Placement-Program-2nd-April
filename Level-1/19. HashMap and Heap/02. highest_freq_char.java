import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        char hfc = highestFreqChar(str);

        System.out.println(hfc);
    }

    public static char highestFreqChar(String str) {

            HashMap < Character, Integer > fmap = new HashMap < > ();

            //populate this freq map
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (fmap.containsKey(ch) == true) {
                    int nf = fmap.get(ch) + 1;
                    fmap.put(ch, nf);
                } else {
                    fmap.put(ch, 1);
                }
            }

            char hfc = '\0';
            int mf = 0;

            for (int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                int val = fmap.get(key);

                if (val > mf) {
                    hfc = key;
                    mf = val;
                }
            }

            return hfc;
    }
}