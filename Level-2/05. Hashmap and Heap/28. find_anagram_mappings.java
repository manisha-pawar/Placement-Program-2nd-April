import java.util.*;

public class Main {
    public static int[] anagramMappings(int[] A, int[] B) {
        HashMap < Integer, ArrayList < Integer >> map = new HashMap < > ();

        for (int i = B.length - 1; i >= 0; i--) {
            int ele = B[i];

            if (map.containsKey(ele) == false) {
                ArrayList < Integer > list = new ArrayList < > ();
                list.add(i);
                map.put(ele, list);
            } else {
                ArrayList < Integer > list = map.get(ele);
                list.add(i);
            }
        }


        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            ArrayList < Integer > list = map.get(A[i]);
            int occ = list.remove(list.size() - 1);

            ans[i] = occ;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
    }

}