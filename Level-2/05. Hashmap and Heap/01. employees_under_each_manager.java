import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //write your code here
        HashMap < String, String > map = new HashMap < > (); //employee vs manager
        String ceo = "";

        while (n-- > 0) {
            String emp = scn.next();
            String man = scn.next();

            map.put(emp, man); //re-think
        }


        HashMap < String, ArrayList < String >> gt = new HashMap < > (); //manager vs (direct employees under manager)

        for (String emp: map.keySet()) {
            String man = map.get(emp);

            if (emp.equals(man) == true) {
                ceo = emp;
                ArrayList < String > list = gt.getOrDefault(man, new ArrayList < > ());
                gt.put(emp, list);
                continue;
            }

            if (gt.containsKey(emp) == false) {
                gt.put(emp, new ArrayList < > ());
            }


            ArrayList < String > list = gt.getOrDefault(man, new ArrayList < > ());
            list.add(emp);
            gt.put(man, list);

        }

        HashMap < String, Integer > res = new HashMap < > ();
        getSize(ceo, gt, res);


        for (String key: res.keySet()) {
            System.out.println(key + " " + res.get(key));
        }
    }

    public static int getSize(String root, HashMap < String, ArrayList < String >> gt, HashMap < String, Integer > res) {

        int s = 0;

        for (String child: gt.get(root)) {
            int cfs = getSize(child, gt, res);
            s += cfs;
        }

        res.put(root, s);
        return s + 1;

    }

}