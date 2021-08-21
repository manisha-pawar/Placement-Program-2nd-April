import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet < Character > unique = new HashSet < > ();
        String ustr = "";
        for (char ch: str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        boolean[] vis = new boolean[ustr.length()];
        words_k_arrangement(1, k, ustr, vis, "");
    }


    public static void words_k_arrangement(int cs, int ts, String ustr, boolean[] vis, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }


        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);

            if (vis[i] == false) {
                vis[i] = true;
                words_k_arrangement(cs + 1, ts, ustr, vis, asf + ch);
                vis[i] = false;
            }
        }
    }

}