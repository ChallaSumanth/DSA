//https://practice.geeksforgeeks.org/problems/de6f6a196aecdfb3e4939ba7729809a5a4bdfe90/1

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        int [] arr1 = new int[26];
        int [] arr2 = new int[26];
        int c = 0;
        int c1 = 0;
        for(int i = 0; i < s.length(); i++)
        {
            arr1[s.charAt(i) - 'a']++;
            if(arr1[s.charAt(i) - 'a'] == 1) c++;
        }
        Node temp = head;
        while(temp != null)
        {
            arr2[temp.data - 'a']++;
            if(arr2[temp.data - 'a'] == arr1[temp.data - 'a'])
                c1++;
            while(arr2[temp.data - 'a'] > arr1[temp.data - 'a'])
            {
                if(arr2[head.data - 'a'] == arr1[head.data - 'a']) c1--;
                arr2[head.data - 'a']--;
                head = head.next;
            }
            if(c1 == c)
            {
                ans.add(head);
                Node t = temp.next;
                temp.next = null;
                temp = t;
                head = t;
                c1 = 0;
                Arrays.fill(arr2,0);
            }
            else
                temp = temp.next;
        }
        return ans;
    }
}