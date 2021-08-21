import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        int k = scn.nextInt();

        HashSet < Character > hs = new HashSet < > ();
        String ustr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hs.contains(ch) == false) {
                ustr += ch;
                hs.add(ch);
            }
        }

        words_k_selection2(1, k, ustr, "", -1);
    }

    public static void words_k_selection2(int cs, int ts, String ustr, String asf, int lci) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (int i = lci + 1; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            words_k_selection2(cs + 1, ts, ustr, asf + ch, i);
        }
    }

}