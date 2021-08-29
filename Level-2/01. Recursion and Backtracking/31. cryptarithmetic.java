import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap < Character, Integer > charIntMap = new HashMap < > ();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    }




    public static void solution(String unique, int idx,
        HashMap < Character, Integer > charIntMap, boolean[] usedNumbers,
        String s1, String s2, String s3) {

        if (idx == unique.length()) {
            if (isValid(charIntMap, s1, s2, s3) == true) {
                //print the mapping
                for (int i = 0; i < 26; i++) {
                    char ch = (char)('a' + i);

                    if (charIntMap.containsKey(ch) == true) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }

                System.out.println();
            }

            return;
        }

        char ch = unique.charAt(idx);

        for (int d = 0; d <= 9; d++) {
            if (usedNumbers[d] == false) {
                usedNumbers[d] = true;
                charIntMap.put(ch, d);
                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[d] = false;
                charIntMap.put(ch, -1);
            }
        }

    }


    public static int stringToInt(HashMap < Character, Integer > charIntmap, String s) {
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int d = charIntmap.get(ch);

            num = num * 10 + d;
        }

        return num;
    }

    public static boolean isValid(HashMap < Character, Integer > charIntmap, String s1, String s2, String s3) {
        int n1 = stringToInt(charIntmap, s1);
        int n2 = stringToInt(charIntmap, s2);
        int n3 = stringToInt(charIntmap, s3);

        return n1 + n2 == n3;
    }


}