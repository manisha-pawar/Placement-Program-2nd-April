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
    
    static class QSPair {
        ListNode head;
        ListNode tail;
        
        QSPair() {
            
        }
        
        QSPair(ListNode head,ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    
    static class ParPair {
        ListNode sh;
        ListNode st;
        ListNode pn;
        ListNode lh;
        ListNode lt;
        
        ParPair() {
            
        }
        
        ParPair(ListNode sh,ListNode st,ListNode pn,ListNode lh,ListNode lt) {
            this.sh = sh;
            this.st = st;
            this.pn = pn;
            this.lh = lh;
            this.lt = lt;
        }
    }
    
    
    public static QSPair merge(QSPair lans,ListNode pn,QSPair rans) {
        
        if(lans.head != null && rans.head != null) {
            //both lans and rans are there
            lans.tail.next = pn;
            pn.next = rans.head;
            
            return new QSPair(lans.head,rans.tail);
        }   
        else if(lans.head != null) {
            //only left ans is there
            lans.tail.next = pn;
            
            return new QSPair(lans.head,pn);
        }
        else {
            //only right ans is there
             pn.next = rans.head;
             
             return new QSPair(pn,rans.tail);
            
        }
    }
    
    public static QSPair quickSort(ListNode head,ListNode tail) {
         if(head == null || head.next == null) {
             return new QSPair(head,head);
         }
         
         ParPair p = partition(head,tail.val);
         
         QSPair lans = quickSort(p.sh,p.st);
         QSPair rans = quickSort(p.lh,p.lt);
         
         QSPair ans = merge(lans,p.pn,rans);
         
         return ans;
         
    }
    
    public static ParPair partition(ListNode head,int pivot) {
        
        ListNode sh = new ListNode(-1);
        ListNode st = sh;
        
        ListNode lh = new ListNode(-1);
        ListNode lt = lh;
        
        ListNode temp = head;
        
        while(temp.next != null) {
            if(temp.val <= pivot) {
                st.next = temp;
                st = st.next;
            }
            else {
                lt.next = temp;
                lt = lt.next;
            }
            temp = temp.next;
        }
        
        ListNode pn = temp;
        
        st.next = null;
        lt.next = null;
        pn.next = null;
        
        return new ParPair(sh.next,st,pn,lh.next,lt);
        
    }
    
    public static ListNode quickSort(ListNode head) {
        ListNode tail = getTail(head);
        QSPair p = quickSort(head,tail);
        
        return p.head;
    }

    public static ListNode getTail(ListNode head) {
        ListNode temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        return temp;
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

        ListNode head = quickSort(h1);
        printList(head);
    }
}