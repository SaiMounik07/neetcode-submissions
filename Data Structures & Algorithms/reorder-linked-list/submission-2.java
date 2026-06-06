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
    public void reorderList(ListNode head) {
        ListNode t = head;
        ListNode s = head;
        ListNode f = head;
        while(f != null && s != null && f.next !=null){
            s = s.next;
            f = f.next.next;
        }
        ListNode se = reverseList(s.next);
        s.next = null;
        ListNode d = new ListNode(0);
        while (t != null && se != null) {
    ListNode nextT = t.next;
    ListNode nextS = se.next;

    t.next = se;
    se.next = nextT;

    t = nextT;
    se = nextS;
}
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode t = head.next;
            head.next = prev;
            prev = head;
            head = t;
        }
        return prev;
    }
    }

