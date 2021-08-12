import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int[]a1 = new int[n1];
        for(int i=0; i < n1;i++) {
            a1[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int[]a2 = new int[n2];
        for(int i=0; i < n2;i++) {
            a2[i] = scn.nextInt();
        }
        
        int[]diff = differenceOf2Arrays(a1,a2);
        
        int idx = 0;
        
        while(idx < diff.length-1 && diff[idx] == 0) {
            idx++;
        }
        
        int fnz = idx;

        
        for(int i=fnz;i < diff.length;i++) {
            System.out.println(diff[i]);
        }
        System.out.println();
    }
    
    public static int[] differenceOf2Arrays(int[]a1,int[]a2) {
        int len = a2.length;
        
        int[]res = new int[len];
        int i = a1.length-1;
        int j = a2.length-1;
        int k = res.length-1;
        
        int borrow = 0;
        
        while(j >= 0) {
            
            int sub = (a2[j] + borrow);
            
            if(i >= 0) {
                sub -= a1[i];
            }
            
            int val = sub;
            if(sub < 0) {
                val += 10;
                borrow = -1;
            }
            else {
                borrow = 0;
            }
            
            res[k] = val;
            
            i--;
            j--;
            k--;
        }
        
        return res;
    }
}