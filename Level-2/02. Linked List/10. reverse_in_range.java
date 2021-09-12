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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode temp = head;
        int pos = 1;
        
        ListNode p1 = null;
        ListNode p2 = null;
        
        ListNode ch = null;
        ListNode ct = null;
        
        while(temp != null) {
            //pre
            if(pos < left) {
                p1 = temp;
                temp = temp.next;
            }
            
            //work
            else if(pos >= left && pos <= right) {
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
            }
            
            //post
            else {
                p2 = temp;
                break;
            }
            
            pos++;
        }
        
        if(p1 != null) {
            p1.next = ch;
            ct.next = p2;
            
            return head;
        }
        else {
            ct.next = p2;
            return ch;
        }
    }
}