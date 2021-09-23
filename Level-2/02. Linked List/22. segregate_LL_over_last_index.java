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

    public static ListNode getTail(ListNode head) {
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {

        ListNode sh = new ListNode(-1);
        ListNode st = sh;

        ListNode lh = new ListNode(-1);
        ListNode lt = lh;

        ListNode tail = getTail(head);
        int pivot = tail.val;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val <= pivot) {
                st.next = temp;
                st = st.next;
            } else {
                lt.next = temp;
                lt = lt.next;
            }
            temp = temp.next;
        }

        lt.next = null;
        st.next = lh.next;

        return st;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}