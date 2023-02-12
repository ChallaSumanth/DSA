class Solution
{
    Node primeList(Node head){
        //code here
        boolean isPrime[] = new boolean[100000];
        Arrays.fill(isPrime,true);
        for(int i = 2; i*i < 100000; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * i; j < 100000; j += i)
                    isPrime[j] = false;
            }
        }
        Node cur = head;
        while(cur != null)
        {
            if(cur.val == 1)
            {
                cur.val = 2;
                cur = cur.next;
                continue;
            }
            int x = cur.val;
            int y = cur.val;
            while(!isPrime[x])
            x--;
            while(!isPrime[y])
            y++;
             if(cur.val-x > y-cur.val)
            {
                cur.val=y;
            }
            else //<=
            cur.val=x;
            cur = cur.next;
        }
        return head;
    }
}