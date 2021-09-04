import java.io.*;
import java.util.*;

public class Main {

    public static String reverse(String asf) {
        String rev = "";

        for (int i = asf.length() - 1; i >= 0; i--) {
            rev += asf.charAt(i);
        }

        return rev;
    }
    public static void generatepw(int cs, int ts, HashMap < Character, Integer > fmap, Character oddc, String asf) {
        if (cs > ts) {
            //create your complete
            String rasf = reverse(asf); // reversed asf

            if (oddc == null) {
                System.out.println(asf + "" + rasf);
            } else {
                System.out.println(asf + oddc + rasf);
            }
        }

        for (char uch: fmap.keySet()) {
            if (fmap.get(uch) > 0) {
                fmap.put(uch, fmap.get(uch) - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + uch);
                fmap.put(uch, fmap.get(uch) + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap < Character, Integer > fmap = new HashMap < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        //write your code here
        int len = 0;
        Character ofc = null; //odd freq char

        for (char key: fmap.keySet()) {
            int freq = fmap.get(key);
            if (freq % 2 == 1) {
                //freq is odd
                if (ofc != null) {
                    //no permutation is palindromic, more than one char has odd freq
                    System.out.println("-1");
                    return;
                }
                ofc = key;
            }
            int nf = freq / 2;
            len += nf;
            fmap.put(key, nf);
        }

        generatepw(1, len, fmap, ofc, "");
    }

}