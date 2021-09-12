import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }



    //O(n) time and O(n) space approach (using hashmap)
    public static ListNode copyRandomList(ListNode head) {

        ListNode dh = new ListNode(-1);
        ListNode dt = dh;

        HashMap < ListNode, ListNode > map = new HashMap < > ();

        //copy values and next pointer
        ListNode temp = head;

        while (temp != null) {
            ListNode nn = new ListNode(temp.val);

            dt.next = nn;
            dt = nn;

            map.put(temp, nn);

            temp = temp.next;
        }

        //copy random pointers in new list
        ListNode p1 = head;
        ListNode p2 = dh.next;

        while (p1 != null) {

            if (p1.random == null) {
                p2.random = null;
            } else {
                p2.random = map.get(p1.random);
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return dh.next;


    }




    //O(n) time & O(1) space approach
    public static ListNode copyRandomList(ListNode head) {
        //1. insert new nodes between old nodes
        ListNode curr = head;

        while (curr != null) {
            ListNode n = curr.next;

            ListNode nn = new ListNode(curr.val);

            curr.next = nn;
            nn.next = n;

            curr = n;
        }


        //2. set random pointers
        ListNode p1 = head;

        while (p1 != null) {
            ListNode p2 = p1.next;

            if (p1.random == null) {
                p2.random = null;
            } else {
                p2.random = p1.random.next;
            }

            p1 = p1.next.next;

        }

        //3. segregate old and new list
        ListNode cllh = head.next; //copied linked list head

        ListNode h1 = head;
        ListNode h2 = cllh;

        while (h1 != null) {
            ListNode n1 = h2.next;

            ListNode n2 = null;

            if (n1 != null) {
                n2 = n1.next;
            }

            h1.next = n1;
            h2.next = n2;

            h1 = n1;
            h2 = n2;
        }


        return cllh;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}