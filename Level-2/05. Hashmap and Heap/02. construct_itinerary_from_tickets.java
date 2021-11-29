import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap < String, String > map = new HashMap < > ();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        //write your code here

        solve(map);

    }


    public static void solve(HashMap < String, String > tickets) {
        HashMap < String, Boolean > map = new HashMap < > ();

        for (String src: tickets.keySet()) {
            String dest = tickets.get(src);

            if (map.containsKey(src) == false) {
                map.put(src, true);
            } else {
                map.put(src, map.get(src));
            }

            map.put(dest, false);
        }


        String src = "";
        for (String key: map.keySet()) {
            if (map.get(key) == true) {
                src = key;
                break;
            }
        }


        //print the journey
        while (tickets.containsKey(src) == true) {
            System.out.print(src + " -> ");
            src = tickets.get(src);
        }

        System.out.println(src + ".");

    }
}