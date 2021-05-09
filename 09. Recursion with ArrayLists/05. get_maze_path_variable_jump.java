import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        ArrayList<String>paths = getMazePaths(0,0,n-1,m-1);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String>ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
        
        ArrayList<String>std = new ArrayList<>();
        
        //horizontal nbr
        for(int i=1; sc + i <= dc ; i++) {
            ArrayList<String>hntd = getMazePaths(sr,sc + i,dr,dc);
            
            for(int j=0; j < hntd.size();j++) {
                std.add("h" + i + hntd.get(j));
            }
            
        }
        
        //vertical nbr
        for(int i=1; sr + i <= dr ; i++) {
            ArrayList<String>vntd = getMazePaths(sr + i,sc,dr,dc);
            
            for(int j=0; j < vntd.size();j++) {
                std.add("v" + i + vntd.get(j));
            }
            
        }
        
        //diagonal nbr
        for(int i=1; sr + i <= dr && sc + i <= dc ; i++) {
            ArrayList<String>dntd = getMazePaths(sr + i ,sc + i,dr,dc);
            
            for(int j=0; j < dntd.size();j++) {
                std.add("d" + i + dntd.get(j));
            }
            
        }
        
        return std;
    }
    
}