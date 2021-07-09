import java.util.ArrayList;
import java.util.Stack;

public class Main {
    
    
    public static class Node {
        int data;
        ArrayList<Node>children;
        
        Node() {
            
        }
        
        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    
    public static Node construct(int[]data) {
        Stack<Node>st = new Stack<>();
        Node root = null;
        
        for(int i=0; i < data.length;i++) {
            if(data[i] == -1) {
                st.pop();
            }
            else {
                Node nn = new Node(data[i]);
                
                if(st.size() > 0) {
                    Node par = st.peek();
                    par.children.add(nn);
                }
                else {
                    root = nn;
                }
                
                st.push(nn);
            }
        }
        
        return root;
    }

    //multisolver
    static int size;
    static int min;
    static int max;
    static int height;

    public static void travel(Node node,int lev) {
        //node pre
        size++;
        min = Math.min(min,node.data);
        max = Math.max(max,node.data);
        height = Math.max(height,lev);

        //travel
        for(Node child : node.children) {
            travel(child,lev+1);
        }
    }

    public static void multisolver(Node node) {
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;

        travel(node,0);
    }
    
   
    public static void main(String[]args) {
       int[]data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
       
       Node root = construct(data);
    
       multisolver(root);
       
       System.out.println("Size : " + size);
       System.out.println("Minimum : " + min);
       System.out.println("Maximum : " + max);
       System.out.println("Height : " + height);

    }
}