//Facebook 7 Microsoft 5 Amazon 5 Google 3 Apple 2 Adobe 2
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
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = null;
        ListNode itr = dummy;
        int count = 0;
        while(count != left)
        {
            cur = itr;
            itr = itr.next;
            count++;
        }
        ListNode index = itr;
        ListNode prev = cur;
        ListNode temp = null;
        while(count <= right)
        {
            temp = index.next;
            index.next = prev;
            prev = index;
            index = temp;
            count++;
        }
        cur.next = prev;
        itr.next = temp;
        return dummy.next;
    }
}