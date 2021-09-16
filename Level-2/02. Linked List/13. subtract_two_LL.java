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

        while (curr != null) {
            ListNode n = curr.next;

            curr.next = prev;

            prev = curr;
            curr = n;
        }

        return prev;
    }

    public static int size(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    //1 -> l1 > l2
    //-1 -> l1 < l2
    //0 -> l1 == l2
    public static int compare(ListNode l1, ListNode l2) {
        int c1 = size(l1);
        int c2 = size(l2);

        if (c1 < c2) {
            return -1;
        } else if (c1 > c2) {
            return 1;
        } else {
            ListNode t1 = l1;
            ListNode t2 = l2;

            while (t1 != null && t2 != null) {
                if (t1.val > t2.val) {
                    return 1;
                } else if (t1.val < t2.val) {
                    return -1;
                } else {
                    t1 = t1.next;
                    t2 = t2.next;
                }
            }
        }

        return 0;
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1 = null; //larger number ptr
        ListNode t2 = null; //smaller number ptr

        int cr = compare(l1, l2);

        if (cr == 0) {
            //both are equals
            return new ListNode(0);
        } else if (cr == 1) {
            //number represented by l1 is larger
            t1 = reverse(l1);
            t2 = reverse(l2);
        } else {
            //number represented by l2 is larger
            t1 = reverse(l2);
            t2 = reverse(l1);
        }

        //subtract t1-t2
        int borrow = 0;
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;

        while (t1 != null) {
            int sub = (t1.val + borrow);

            if (t2 != null) {
                sub -= t2.val;
                t2 = t2.next;
            }

            if (sub < 0) {
                sub += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            ListNode nn = new ListNode(sub);
            dt.next = nn;
            dt = dt.next;

            t1 = t1.next;
        }

        ListNode ans = reverse(dh.next);

        //shifiting the head to avoid leading zero
        while (ans != null && ans.val == 0) {
            ans = ans.next;
        }

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

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }

}