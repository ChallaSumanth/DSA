//Amazon 28
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
    public int pairSum(ListNode head) {
        if(head.next == null)
            return head.val;
        if(head.next.next == null)
            return head.val + head.next.val;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode lastNode = reverseList(secondHalf);
        ListNode cur = head;
        int ans = Integer.MIN_VALUE;
        while(cur != null)
        {
            ans = Math.max(ans, cur.val + lastNode.val);
            cur = cur.next;
            lastNode = lastNode.next;
        }
        return ans;
    }
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}