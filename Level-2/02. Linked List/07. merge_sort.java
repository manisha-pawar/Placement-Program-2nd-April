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

    public static ListNode middle(ListNode head) {
        if(head == null) {
            return null;
        }    
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                dt.next = p1;
                p1 = p1.next;
            }
            else {
                dt.next = p2;
                p2 = p2.next;
            }
            dt = dt.next;
        }
        
        if(p1 != null) {
            dt.next = p1;
        }
        
        if(p2 != null) {
            dt.next = p2;
        }
        
        return dh.next;
        
    }
    
    public static ListNode mergeSort(ListNode head) {
        if(head.next == null) {
            return head;
        }
        
        ListNode mid = middle(head);
        ListNode rh = mid.next;
        
        mid.next = null;
        
        ListNode lp = mergeSort(head);
        ListNode rp = mergeSort(rh);
        
        ListNode ma = mergeTwoLists(lp,rp); //merged answer
        return ma;
    }
    

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
    }
}