//https://leetcode.com/problems/merge-two-sorted-lists/

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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}