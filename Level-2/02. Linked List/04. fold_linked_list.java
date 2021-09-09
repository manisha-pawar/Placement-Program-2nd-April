//https://leetcode.com/problems/reorder-list/

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
    
    public static ListNode reverse(ListNode head) {
        ListNode c = head;
        ListNode p = null;
        
        while(c != null) {
            ListNode n = c.next;
            
            c.next = p;
            
            p = c;
            c = n;
        }
        
        return p;
    }
    
    public void reorderList(ListNode head) {
        ListNode mid = middle(head);
        ListNode nh = mid.next;
        
        mid.next = null;
        
        ListNode r = reverse(nh); //right head
        ListNode l = head; //left head
        
        while(r != null) {
            //backup
            ListNode ln = l.next; //left next
            ListNode rn = r.next; //right next
            
            //connection
            l.next = r;
            r.next = ln;
            
            //move
            l = ln;
            r = rn;
        }
        
    } 
}