import java.util.*;

public class Main{

    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n=scn.nextInt();
      
      int pv = 1;
      int inv = 0;
      
      while(n > 0) {
          int d = n % 10;
          n = n/10;
          
          inv += pv * (int)(Math.pow(10,d-1));
          pv++;
      }
      
      System.out.println(inv);
    }
}