import java.util.*;

public class Main {
    public static void main(String[]args) {
        HashMap<String,Integer>hm = new HashMap<>();
        
        //put -> addition
        hm.put("India",100);
        hm.put("Pak",90);
        hm.put("SL",450);
        hm.put("AFG",490);
        
        // System.out.println(hm);
        
        //put -> updation
        hm.put("SL",99);
        
        //System.out.println(hm);
        
        // //get
        // System.out.println(hm.get("India")); //key is present -> value
        // System.out.println(hm.get("Nig")); //key is absent -> null
        
        
        // //containsKey
        // System.out.println(hm.containsKey("India")); //key is present -> true
        // System.out.println(hm.containsKey("Nig")); //key is absent -> false
        
        //remove
        hm.remove("AFG");
        
        // System.out.println(hm);
        
        // for(String key : hm.keySet()) {
        //     System.out.println(key + " -> " + hm.get(key));
        // }
        
        ArrayList<String>list = new ArrayList<>(hm.keySet());
        
        for(int i=0; i < list.size();i++) {
            String key = list.get(i);
            System.out.println(key + " -> " + hm.get(key));
        }
        
    }
}