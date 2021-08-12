import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        int spc = 1;
        int stc = (n + 1)/2;
        
        for(int r = 1; r <= n;r++) {
            //print left stars
            for(int i=1; i <= stc;i++) {
                System.out.print("*	");
            }
            
            //print spaces
            for(int i=1; i <= spc;i++) {
                System.out.print("	");
            }
            
            //print right stars
            for(int i=1; i <= stc;i++) {
                System.out.print("*	");
            }
            
            System.out.println();
            
            if(r <= n/2) {
                stc--;
                spc+=2;
            }
            else if(r > n/2) {
                stc++;
                spc-=2;
            }
        }

    }
}