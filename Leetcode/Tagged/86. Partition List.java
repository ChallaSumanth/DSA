//Adobe 2
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
    public ListNode partition(ListNode head, int x) {
        ListNode before_x = new ListNode(0);
        ListNode before = before_x;
        ListNode after_x = new ListNode(0);
        ListNode after = after_x;
        while(head != null)
        {
            if(head.val < x)
            {
                before.next = head;
                before = before.next;
            }
            else
            {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_x.next;
        return before_x.next;
    }
}