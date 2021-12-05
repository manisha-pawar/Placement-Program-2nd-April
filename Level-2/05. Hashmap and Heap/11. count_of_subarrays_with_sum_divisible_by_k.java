import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap < Integer, Integer > map = new HashMap < > (); //ps % k vs freq
        int ps = 0;
        int count = 0;
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            ps += arr[i];
            int rem = ps % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem) == true) {
                int of = map.get(rem);
                count += of ;
                map.put(rem, of +1);
            } else {
                map.put(rem, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}