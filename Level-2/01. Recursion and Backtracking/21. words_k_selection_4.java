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

        words_k_selection_4(1, k, ustr, unique, "", 0);

    }

    public static void words_k_selection_4(int cs, int ts, String ustr, HashMap < Character, Integer > map, String asf, int lci) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (int i = lci; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);

            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                words_k_selection_4(cs + 1, ts, ustr, map, asf + ch, i);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }

}