import java.io.*;
import java.util.*;

public class Main {
    
    static String[]codes = {".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String>kpc = getKPC(str);
        System.out.println(kpc);
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0) {
            ArrayList<String>ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
       
       char ch = str.charAt(0); 
       String ros = str.substring(1); 
       
       ArrayList<String>rans = getKPC(ros); 
       ArrayList<String>myans = new ArrayList<>();
       
       String mycode = codes[ch - '0']; 
       
       for(int i=0; i < mycode.length();i++) {
           
           for(int j=0; j < rans.size();j++) {
               String code =  mycode.charAt(i) + rans.get(j);
               myans.add(code);
           }
       }
       
       return myans;
       
       
    }

}