// Bloomberg 6 Microsoft 4 Amazon 3 Oracle 2
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
//1.reversing input list
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0)
        {
           int num1 = l1 == null ? 0 : l1.val;
           int num2 = l2 == null ? 0 : l2.val;
           int sum = num1 + num2 + carry;
           l3.next = new ListNode(sum % 10);
           carry = sum / 10;
           if(l1 != null)
                l1 = l1.next;
           if(l2 != null)
                l2 = l2.next;
           l3 = l3.next;
        }
        return reverseList(head.next);
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
//2.without reversing
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
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null)
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode list = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0 ? list.next : list;
    }
}