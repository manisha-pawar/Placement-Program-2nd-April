import java.util.*;

public class Main{
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int hi = scn.nextInt();
        
        for(int num = low ; num <= hi;num++) {
            
            boolean isPrime = true;
            
            for(int div = 2; div * div <= num;div++) {
                if(num %  div == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime == true) {
                System.out.println(num);
            }
        }
    }
}