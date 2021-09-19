import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        
        ListNode itr = head;
        ListNode curr = itr.next;
        
        dt.next = itr;
        
        while(curr != null) {
            boolean isDuplicate = false;
            
            while(curr != null && itr.val == curr.val) {
                isDuplicate = true;
                curr = curr.next;
            }
            
            if(isDuplicate == true) {
                dt.next = curr;
            }
            else {
                dt = dt.next;
            }
            
            itr = curr;
            
            if(itr != null)
            curr = itr.next;
        }
        
        return dh.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}