//Amazon 2 Oracle 2 Apple 2
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode cur = head;
        while(cur != null)
        {
            len++;
            cur = cur.next;
        }
        int n = len / k;
        int distribute = len % k;
        ListNode node = head;
        ListNode prev = null;
        for(int i = 0; node != null; i++)
        {
            ans[i] = node;
            for(int j = 0; j < n + (distribute > 0 ? 1 : 0); j++)
            {
                prev = node;
                node = node.next;
            }
            distribute--;
            prev.next = null;
        }
        return ans;
    }
}
