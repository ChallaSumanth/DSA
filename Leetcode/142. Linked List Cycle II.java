//1.Brute force - Hashing (traverse and hash all nodes and check if node contains while hashing) 

//2.optimal

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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                while(start != slow)
                {
                    slow = slow.next;
                    start = start.next;
                }
                return slow;
            }
        }
        return null;
    }
}