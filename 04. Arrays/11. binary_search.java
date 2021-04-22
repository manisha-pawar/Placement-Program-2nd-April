import java.util.Scanner;
 
 public class Main {
 
 	 public static int search(int[] ar, int data) {
        int lo = 0;
        int hi = ar.length - 1;
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            if(ar[mid] == data) {
                return mid;
            }
            else if(ar[mid] < data) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return -1;
        
 	 }
 
 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 int n = s.nextInt();
 	 	 int[] ar = new int[n];
 	 	 for (int i = 0; i < ar.length; i++) {
 	 	 	 ar[i] = s.nextInt();
 	 	 }
 	 	 int key = s.nextInt();
 	 	 System.out.println(search(ar, key));
 	 }
 }