class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         Node a = head1;
         Node b = head2;
         
         while(a != b)
         {
             a = a == null ? head2 : a.next;
             b = b == null ? head1 : b.next;
         }
         return a == null ? -1 : a.data;
	}
}
