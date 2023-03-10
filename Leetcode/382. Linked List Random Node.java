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
//tc:O(n) sc:O(n)
class Solution {
    private List<Integer> list = null;
    private Random rand = null;
    public Solution(ListNode head) {
        list = new ArrayList<>();
        rand = new Random();
        ListNode cur = head;
        while(cur != null)
        {
            list.add(cur.val);
            cur = cur.next;
        }
    }
    
    public int getRandom() {
        int size = list.size();
        int index = rand.nextInt(size);
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//2. tc : O(n) sc:O(1)
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
    private ListNode cur = null;
    private Random rand = null;
    public Solution(ListNode head) {
        cur = head;
        rand = new Random();
    }
    
    public int getRandom() {
        ListNode c = cur;
        int ans = cur.val;
        for(int i = 1; c.next != null ; i++)
        {
            c = c.next;
            if(rand.nextInt(i + 1) == i) ans = c.val;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */