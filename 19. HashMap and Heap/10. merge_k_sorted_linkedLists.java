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
    
    public static class Helper implements Comparable<Helper>{
        ListNode node;
        
        Helper() {
        
        }
        
        Helper(ListNode node) {
            this.node = node;
        }
        
        public int compareTo(Helper o) {
            return this.node.val - o.node.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Helper>pq = new PriorityQueue<>();
        ListNode dnh = new ListNode(-1);
        ListNode dnt = dnh;
        
        for(int i=0; i < lists.length;i++) {
            ListNode node = lists[i];
            if(node != null) {
                pq.add(new Helper(node));
            }
        }
        
        while(pq.size() > 0) {
            Helper rem = pq.remove();
            
            //add last
            ListNode nn = new ListNode(rem.node.val);
            dnt.next = nn;
            dnt = nn;
            
            if(rem.node.next != null ){
                pq.add(new Helper(rem.node.next));
            }
        }
        
        return dnh.next;
        
    }  
    
}