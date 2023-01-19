class Solution {
    //Function to find first node if the linked list has a loop.
    public static int findFirstNode(Node head){
        //code here
        if(head.next == null)
            return head.data;
        Node slow = head;
        Node fast = head;
        Node prev = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
               {
                   while(prev != slow)
                  {
                   prev = prev.next;
                   slow = slow.next;
                  }
                   return prev.data;
               }
        }
        return -1;
    }
}