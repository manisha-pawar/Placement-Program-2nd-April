import java.io.*;
import java.util.*;

public class Main {

    //cs -> current slot
    //ts -> total slot

    public static void generateWords(int cs, int ts, HashMap < Character, Integer > fmap, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (char uch: fmap.keySet()) {
            if (fmap.get(uch) > 0) {
                fmap.put(uch, fmap.get(uch) - 1);
                generateWords(cs + 1, ts, fmap, asf + uch);
                fmap.put(uch, fmap.get(uch) + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap < Character, Integer > fmap = new HashMap < > ();
        for (char ch: str.toCharArray()) {
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        generateWords(1, str.length(), fmap, "");
    }

}