//https://leetcode.com/problems/palindrome-linked-list/


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
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);
        ListNode nh = mid.next;
        
        mid.next = null;
        
        ListNode rh = reverse(nh); //right head
        ListNode lh = head; //left head
        
        while(rh != null) {
            if(lh.val != rh.val) {
                return false;
            }
            lh = lh.next;
            rh = rh.next;
        }
        
        return true;
        
    }
    
}