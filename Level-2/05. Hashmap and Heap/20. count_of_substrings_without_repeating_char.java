import java.util.*;

public class Main {

    public static int solution(String str) {
        // write your code here

        HashMap < Character, Integer > map = new HashMap < > ();

        int i = -1;
        int j = -1;
        int count = 0;

        while (i < str.length() - 1) {
            //aquire
            while (i < str.length() - 1) {
                i++;

                char ch = str.charAt(i);
                int of = map.getOrDefault(ch, 0);
                map.put(ch, of +1);

                if (map.get(ch) > 1) {
                    break;
                } 
                else {
                    count += (i - j);
                }
            }

            //release
            while (j < i) {
                j++;

                char ch = str.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } 
                else {
                    int of = map.get(ch);
                    map.put(ch, of -1);
                    count += (i - j);
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}