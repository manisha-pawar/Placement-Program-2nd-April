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
    
    public static int size(ListNode head) {
        int count = 0;
        ListNode temp = head;
        
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        
        return count;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = size(head);
        
        if(count < k) {
            return head;    
        }
        
        ListNode ah = null;
        ListNode at = null;
        
        ListNode temp = head;
        
        while(count >= k) {
            ListNode ch = null;
            ListNode ct = null;
            
            for(int i = 1; i <= k;i++) {
                ListNode n = temp.next;
                
                //removefirst
                temp.next = null;
                
                //addfirst
                if(ch == null) {
                    ch = ct = temp;
                }
                else {
                    temp.next = ch;
                    ch = temp;
                }
                
                temp = n;
                count--;
            }
            
            //introduce this current group in you overall ans
            if(ah == null) {
                ah = ch;
                at = ct;
            }
            else {
                at.next = ch;
                at = ct;
            }
            
            
        }
        
        if(count > 0) {
            at.next = temp;
        }
        
        return ah;
    }
    
}