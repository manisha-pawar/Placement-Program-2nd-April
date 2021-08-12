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
    
    public static void display(Node node) {
        //node & its children
        System.out.print(node.data + " -> ");
        for(int i=0; i < node.children.size();i++) {
            Node child = node.children.get(i);
            System.out.print(child.data + " ");
        }
        System.out.println(".");
        
        for(int i=0; i < node.children.size();i++) {
            Node child = node.children.get(i);
            display(child);
        }
    }
    
    public static void main(String[]args) {
       int[]data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
       
       Node root = construct(data);
    
       display(root);
    }
}