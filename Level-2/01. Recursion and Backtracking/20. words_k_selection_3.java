import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap < Character, Integer > unique = new HashMap < > ();
        String ustr = "";
        for (char ch: str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        words_k_selection_3(0, ustr, unique, "", 0, k);

    }

    public static void words_k_selection_3(int idx, String ustr, HashMap < Character, Integer > map, String asf, int ssf, int ts) {
        if (idx == ustr.length()) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(idx);
        int freq = map.get(ch);

        for (int i = freq; i >= 0; i--) {
            String s = "";

            for (int j = 1; j <= i; j++) {
                s += ch;
            }

            words_k_selection_3(idx + 1, ustr, map, asf + s, ssf + i, ts);
        }
    }

}