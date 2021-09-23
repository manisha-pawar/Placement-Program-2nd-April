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

    public static ListNode segregate012(ListNode head) {

        ListNode zh = new ListNode(-1);
        ListNode zt = zh;

        ListNode oh = new ListNode(-1);
        ListNode ot = oh;

        ListNode th = new ListNode(-1);
        ListNode tt = th;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                zt.next = temp;
                zt = zt.next;
            } else if (temp.val == 1) {
                ot.next = temp;
                ot = ot.next;
            } else {
                tt.next = temp;
                tt = tt.next;
            }
            temp = temp.next;
        }

        ot.next = th.next;
        zt.next = oh.next;

        tt.next = null;

        return zh.next;

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
        h1 = segregate012(h1);
        printList(h1);
    }
}