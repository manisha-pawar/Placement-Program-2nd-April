import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String pattern, int idx, HashMap < Character, String > map, HashSet < String > vis) {
        if (idx == pattern.length()) {
            if (str.length() == 0) {
                HashSet < Character > hs = new HashSet < > ();
                for (int i = 0; i < pattern.length(); i++) {
                    char ch = pattern.charAt(i);
                    if (hs.contains(ch) == false) {
                        hs.add(ch);
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(idx);

        if (map.containsKey(ch) == false) {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);

                if (vis.contains(left) == false) {
                    map.put(ch, left);
                    vis.add(left);
                    solution(right, pattern, idx + 1, map, vis);
                    map.remove(ch);
                    vis.remove(left);
                }
            }
        } else {
            boolean flag = false;
            String right = "";
            String pmapping = map.get(ch); //previous mapping
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);

                if (left.equals(pmapping) == true) {
                    right = str.substring(i + 1);
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                return;
            } else {
                solution(right, pattern, idx + 1, map, vis);
            }

        }

    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap < Character, String > map = new HashMap < > ();
        solution(str, pattern, 0, map, new HashSet < > ());
    }
}