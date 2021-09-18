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
    
    
    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode n = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = n;
        }
        
        return prev;
    }
    
    public static ListNode singleDigitMult(ListNode t1,int d) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        int carry = 0;
        
        while(t1 != null || carry != 0) {
            int mult = carry;
            
            if(t1 != null) {
                mult += t1.val * d;
                t1 = t1.next;
            }
            
            int val = mult % 10;
            carry = mult / 10;
            
            ListNode nn = new ListNode(val);
            dt.next = nn;
            dt = dt.next;
        }
        
        return dh;
    }
    
    public static void addition(ListNode ptr,ListNode ch) {
        //oh -> overall ans head
        //ch -> current linked list head
        
        //task  overall ans = overall ans + current ans
        
        ListNode op = ptr;
        ListNode cp = ch;
        
        int carry = 0;
        
        while(op.next != null || cp.next != null || carry != 0) {
            int sum = carry;
            
            if(op.next != null) {
                sum += op.next.val;
            }
            
            if(cp.next != null) {
                sum += cp.next.val;
                cp = cp.next;
            }
            
            int val = sum % 10;
            carry = sum / 10;
            
            if(op.next != null) {
                op.next.val = val;
                op = op.next;
            }
            else {
                op.next = new ListNode(val);
                op = op.next;
            }
            
        }
        
    }
    
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        
        ListNode oh = new ListNode(-1);
        ListNode ot = oh;
        
        ListNode ptr = oh;
        
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
        
        while(t2 != null) {
            int d = t2.val;
            t2 = t2.next;
            
            ListNode sans = singleDigitMult(t1,d);
            addition(ptr,sans);
            
            ptr = ptr.next;
        }
        
        ListNode ans = reverse(oh.next);
        return ans;
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}