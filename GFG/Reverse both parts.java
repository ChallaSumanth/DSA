//https://practice.geeksforgeeks.org/problems/bae68b4d6a2a77fb6bd459cf7447240919ebfbf5/1
class Solution {
    public static Node reverse(Node head, int k) {
        // code here
        int count = 0;
        Node prev = null;
        Node cur = head;
        Node next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        Node temp = prev;
        count = count - k - 1;
        while(count-- != 0)
            temp = temp.next;
        head.next = prev;
        head = temp.next;
        temp.next = null;
        return head;
    }
}