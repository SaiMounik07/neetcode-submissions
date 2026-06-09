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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode curr = node;
        int c =0;
        while(l1 != null || l2 != null || c !=0){
            int v1 = (l1 == null)? 0:l1.val;
            int v2 = (l2 == null)? 0:l2.val;
            int v = v1+v2+c;
            c = v/10;
            int val = v%10;
            
            curr.next = new ListNode(val);
            curr = curr.next;
             l1 = l1 != null ? l1.next : null;
             l2 = l2 != null ? l2.next : null;


        }
        return node.next;
    }
}