class Solution{
	int minSteps(String str) {
		//Write your code here
		int count = 1;
		int len = str.length();
		for(int i = 1; i < len; i++)
		    if(str.charAt(i) != str.charAt(i - 1)) count++;
		return (count / 2) + 1;
	}
}