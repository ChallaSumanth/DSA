//https://practice.geeksforgeeks.org/problems/d25f415de2ff3e02134de03e17ad019d723ab2e9/1
//Google
class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
        long ans = 0;
        if(X > Y)
           ans = help(S, X, Y, "pr");
        else
           ans = help(S, Y, X, "rp");
        return ans;
	}
	private static long help(String S, int first, int second, String remove)
	{
	    Stack<Character> st = new Stack<>();
	    int len = S.length();
	    long total = 0;
	    for(int i = 0; i < len; i++)
	    {
	        if(!st.isEmpty() && S.charAt(i) == remove.charAt(1) && st.peek() == remove.charAt(0))
	        {
	            total += first;
	            st.pop();
	        }
	        else
	            st.push(S.charAt(i));
	    }
	    StringBuilder sb = new StringBuilder();
	    while(!st.isEmpty())
	        sb.append(st.pop());
	   for(int i = 0; i < sb.length(); i++)
	   {
	       if(!st.isEmpty() && sb.charAt(i) == remove.charAt(1) && st.peek() == remove.charAt(0))
	       {
	           total += second;
	           st.pop();
	       }
	       else
	            st.push(sb.charAt(i));
	   }
	   return total;
	}
} 
