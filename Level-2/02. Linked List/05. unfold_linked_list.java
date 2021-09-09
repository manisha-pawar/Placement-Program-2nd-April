import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode reverse(ListNode head) {
        ListNode c = head;
        ListNode p = null;
        
        while(c != null) {
            ListNode n = c.next;
            
            c.next = p;
            
            p = c;
            c = n;
        }
        
        return p;
    }
    
    public static void unfold(ListNode head) {
        ListNode lh = new ListNode(-1); //dummy node for left part
        ListNode lt = lh;
        
        ListNode rh = new ListNode(-1); //dummy node for right part
        ListNode rt = rh;
        
        ListNode temp = head;
        boolean flag = true;
        
        while(temp != null) {
            if(flag == true) {
                //add in left part
                lt.next = temp;
                lt = lt.next;
            }
            else {
                //add in right part
                rt.next = temp;
                rt = rt.next;
            }
            
            flag = !flag; //tweak
            temp = temp.next;
        }
        
        rt.next = null;
        
        rh = reverse(rh.next);
        lt.next = rh;
        
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}