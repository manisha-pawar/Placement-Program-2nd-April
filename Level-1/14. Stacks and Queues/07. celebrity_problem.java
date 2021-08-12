import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (arr[i][j] == 0) {
                //j can't be a celebrity
                j--;
            } else {
                //i can't be a celebrity
                i++;
            }
        }

        int pc = i; //potential celebrity

        //row check
        for (int c = 0; c < n; c++) {
            if (c != pc && arr[pc][c] != 0) {
                System.out.println("none");
                return;
            }
        }

        //col check
        for (int r = 0; r < n; r++) {
            if (r != pc && arr[r][pc] == 0) {
                System.out.println("none");
                return;
            }
        }

        System.out.println(pc);

    }

}