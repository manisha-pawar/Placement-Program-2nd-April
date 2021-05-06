import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1id = scn.nextInt();
        int t2id = scn.nextInt();
        int t3id = scn.nextInt();
        
        toh(n,t1id,t2id,t3id); //n, src, dest, helper
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n == 0) {
            return;
        }
        
        //to move n-1 disks from t1 to t3 using t2
        toh(n-1,t1id,t3id,t2id);
        
        //my work - to move nth disk from t1 to t2
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        
        //to move n-1 disks from t3 to t2
        toh(n-1,t3id,t2id,t1id);
        
    }

}