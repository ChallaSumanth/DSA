//Amazon 9 Spotify 4 Microsoft 3 Oracle 3 Visa 3 Google 2 Goldman Sachs 2
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if( head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        while(fast != null && fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
