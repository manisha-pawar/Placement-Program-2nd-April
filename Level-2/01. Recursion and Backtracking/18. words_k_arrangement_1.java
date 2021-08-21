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

        char[] spots = new char[k];

        Arrays.fill(spots, '0');

        words_k_arrangement(0, ustr, spots, 0);

    }

    public static void words_k_arrangement(int idx, String ustr, char[] spots, int ssf) {
        if (idx == ustr.length()) {
            if (ssf == spots.length) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(idx);

        //yes choice
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == '0') {
                spots[i] = ch;
                words_k_arrangement(idx + 1, ustr, spots, ssf + 1);
                spots[i] = '0';
            }
        }

        //no choice
        words_k_arrangement(idx + 1, ustr, spots, ssf);
    }

}