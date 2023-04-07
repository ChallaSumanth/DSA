//https://practice.geeksforgeeks.org/problems/55dbfdc246f3f62d6a7bcee7664cacf6be345527/1
//Samsung
class Solution
{
	public static int addMinChar(String str){
		//code here
		int len = str.length();
		int end = len - 1;
		while(end >= 0)
		{
		    if(isPalindrome(str, end))
		        return len - 1 - end;
		    end--;
		}
		return -1;
	}
	private static boolean isPalindrome(String str, int end)
	{
	    int start = 0;
	    while(start < end)
	    {
	        if(str.charAt(start) != str.charAt(end)) return false;
	        
	        start++;
	        end--;
	    }
	    return true;
	}
}
//optimal
class Solution
{
	public static int addMinChar(String str){
		//code here
		int len = str.length();
		int i = 0;
		int j = len - 1;
		int lastGood = len - 1;
		while(i <= j)
		{
		    if(str.charAt(i) == str.charAt(j))
		    {
		        i++;
		        j--;
		    }
		    else
		    {
		        i = 0;
		        lastGood--;
		        j = lastGood;
		    }
		}
		return len - 1 - lastGood;
	}
}
