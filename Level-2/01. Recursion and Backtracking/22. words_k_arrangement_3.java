import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap < Character, Integer > map = new HashMap < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, -1);
        }

        char[] spots = new char[k];

        Arrays.fill(spots, '0');

        words_k_arrangement_3(0, str, 0, k, map, spots);
    }

    public static void words_k_arrangement_3(int idx, String str, int ssf, int ts, HashMap < Character, Integer > lastOcc, char[] spots) {
        if (idx == str.length()) {
            if (ssf == ts) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }


        char ch = str.charAt(idx);
        int loch = lastOcc.get(ch);

        //yes call
        for (int i = loch + 1; i < spots.length; i++) {
            if (spots[i] == '0') {
                spots[i] = ch;
                lastOcc.put(ch, i);
                words_k_arrangement_3(idx + 1, str, ssf + 1, ts, lastOcc, spots);
                lastOcc.put(ch, loch);
                spots[i] = '0';
            }
        }

        //no call
        if (loch == -1) {
            words_k_arrangement_3(idx + 1, str, ssf, ts, lastOcc, spots);
        }
    }

}