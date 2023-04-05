//https://practice.geeksforgeeks.org/problems/6a1b365b520f10c8a29b533eb72951b4b4237b57/1
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