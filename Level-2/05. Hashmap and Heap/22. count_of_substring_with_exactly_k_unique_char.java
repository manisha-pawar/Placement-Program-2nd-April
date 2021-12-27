import java.util.*;

public class Main {

    public static int solution(String str, int k) {
        int count = atmostKDistinctChar(str, k) - atmostKDistinctChar(str, k - 1);
        return count;
    }


    public static int atmostKDistinctChar(String str, int k) {  
        HashMap < Character, Integer > map = new HashMap < > ();
        int count = 0;
        int i = -1;
        int j = -1;

        while (i < str.length() - 1) {

            //aquire
            while (i < str.length() - 1 && map.size() <= k) {
                i++;

                char ch = str.charAt(i);
                int nf = map.getOrDefault(ch, 0) + 1;
                map.put(ch, nf);

                if (map.size() <= k) {
                    count += (i - j);
                }
            }

            //release
            while (j < i && map.size() == k + 1) {
                j++;

                char ch = str.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);

                    //valid
                    count += (i - j);
                    break;
                } else {
                    int nf = map.get(ch) - 1;
                    map.put(ch, nf);
                }
            }

        }

        return count;
    }
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }

}