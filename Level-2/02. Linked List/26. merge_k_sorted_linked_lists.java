//https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//1. using priority queue
class Solution {
    public static class Pair implements Comparable < Pair > {
        ListNode node;

        Pair() {

        }

        Pair(ListNode node) {
            this.node = node;
        }

        //this < o -> -ve
        //this > o -> +ve
        //this == o -> 0
        public int compareTo(Pair o) {
            return this.node.val - o.node.val;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;

        PriorityQueue < Pair > pq = new PriorityQueue < > ();

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];

            if (node == null) {
                continue;
            }

            Pair p = new Pair(node);
            pq.add(p);
        }

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            ListNode node = rem.node;

            dt.next = node;
            dt = dt.next;

            if (node.next != null) {
                pq.add(new Pair(node.next));
            }
        }

        return dh.next;
    }
}



//2. using merging(divide and conquer)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return merging(lists, 0, lists.length - 1);
    }

    public static ListNode mergeTwoSortedLL(ListNode h1, ListNode h2) {
        ListNode p1 = h1;
        ListNode p2 = h2;

        ListNode dh = new ListNode(-1);
        ListNode dt = dh;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dt.next = p1;
                p1 = p1.next;
            } else {
                dt.next = p2;
                p2 = p2.next;
            }
            dt = dt.next;
        }

        if (p1 != null) {
            dt.next = p1;
        } else if (p2 != null) {
            dt.next = p2;
        }

        return dh.next;
    }

    public static ListNode merging(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }

        int mid = (lo + hi) / 2;

        ListNode left = merging(lists, lo, mid);
        ListNode right = merging(lists, mid + 1, hi);

        ListNode ans = mergeTwoSortedLL(left, right);
        return ans;
    }
}