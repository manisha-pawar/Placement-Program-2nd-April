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
        
        if(sr > dr || sc > dc) {
            ArrayList<String>ba = new ArrayList<>();
            return ba;
        }
        
        ArrayList<String>hntd = getMazePaths(sr,sc+1,dr,dc); // horizontal nbr to dest paths
        ArrayList<String>vntd = getMazePaths(sr+1,sc,dr,dc); // vertical nbr to dest paths
        
        ArrayList<String>stod = new ArrayList<>(); // src to dest paths
        
        //src to dest ->'h' + horizontal nbr to dest
        for(int i=0;i < hntd.size();i++) {
            stod.add('h'+ hntd.get(i));
        }
        
        //src to dest -> 'v' + vertical nbr to dest
        for(int i=0; i < vntd.size();i++) {
            stod.add('v' + vntd.get(i));
        }
        
        return stod;
    }
    
}