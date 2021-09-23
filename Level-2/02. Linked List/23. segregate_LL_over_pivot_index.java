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

    public static ListNode getNodeAt(ListNode head, int idx) {
        ListNode temp = head;
        int ci = 0;

        while (temp != null && ci < idx) {
            temp = temp.next;
            ci++;
        }

        return temp;
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {

        ListNode pn = getNodeAt(head, pivotIdx); //pivot node
        int pd = pn.val; //pivot data

        ListNode sh = new ListNode(-1);
        ListNode st = sh;

        ListNode lh = new ListNode(-1);
        ListNode lt = lh;

        ListNode temp = head;

        while (temp != null) {
            if (temp == pn) {
                //ignore this node
            } else if (temp.val <= pd) {
                st.next = temp;
                st = st.next;
            } else if (temp.val > pd) {
                lt.next = temp;
                lt = lt.next;
            }
            temp = temp.next;
        }

        lt.next = null;

        st.next = pn;
        pn.next = lh.next;

        return sh.next;
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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}