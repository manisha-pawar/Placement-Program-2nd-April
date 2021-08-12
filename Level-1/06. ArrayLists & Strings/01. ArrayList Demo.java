import java.util.*;

public class Main {
    
    public static void main(String[]args) {
        ArrayList<Integer>list = new ArrayList<>();
        
        list.add(10); 
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        
        // System.out.println(list);
        //System.out.println(list.size());
        
        list.remove(0); //which index to be removed
        
        System.out.println(list);
        
        //to get a value
        int val = list.get(1);
        // System.out.println(val);
        
        //to set a value
        list.set(2,99);
        
        System.out.println(list);
        
        
    }
}