//Facebook 64 Amazon 19 Microsoft 12 Bloomberg 3 Google 3 Apple 2
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node itr = head;
        Node front = head;
        while(itr != null)
        {
            front = front.next;
            Node copyNode = new Node(itr.val);
            itr.next = copyNode;
            copyNode.next = front;
            itr = front;
        }
        Node itr1 = head;
        while(itr1 != null)
        {
            if(itr1.random != null)
            {
                itr1.next.random = itr1.random.next;
            }
            itr1 = itr1.next.next;
        }
        Node cur = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while(cur != null)
        {
            front = cur.next.next;
            copy.next = cur.next;
            cur.next = front;
            cur = front;
            copy = copy.next;
        }
        return dummy.next;
    }
}
