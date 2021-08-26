import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap < Character, Integer > map = new HashMap < > ();
        String ustr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch) == true) {
                int nf = map.get(ch) + 1;
                map.put(ch, nf);
            } else {
                map.put(ch, 1);
                ustr += ch;
            }
        }

        words_k_arrangement_4(1, k, ustr, map, "");
    }

    public static void words_k_arrangement_4(int cs, int ts, String ustr, HashMap < Character, Integer > map, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }


        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);

            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                words_k_arrangement_4(cs + 1, ts, ustr, map, asf + ch);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }

}