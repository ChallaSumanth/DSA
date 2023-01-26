class Solution {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        Stack<Integer> st = new Stack<>();
        int index=0;
        for(int i=0;i<n;i++)
        {
            if(st.size() != k)
                st.push(arr.get(i));
            else if(st.size() == k)
            {
                while(!st.isEmpty())
                    arr.set(index++,st.pop());
                i--;
            }
        }
        int lo = index;
        int hi = n-1;
        while(lo < hi)
        {
            int temp = arr.get(lo);
            arr.set(lo,arr.get(hi));
            arr.set(hi,temp);
            lo++;
            hi--;
        }
    }
}
