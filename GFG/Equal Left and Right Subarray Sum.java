//https://practice.geeksforgeeks.org/problems/78a6854c8a2915e05f236aa407dfaa1bbc8ae7d3/1
//Amazon,Adobe
//1.
class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		int [] preSum = new int[N];
		int [] sufSum = new int[N];
		
		preSum[0] = A[0];
		for(int i = 1; i < N; i++)
		{
		    preSum[i] += preSum[i - 1] + A[i];
		}
		sufSum[N - 1] = A[N - 1];
		for(int i = N - 2; i >= 0; i--)
		{
		    sufSum[i] = sufSum[i + 1] + A[i];
		}
		for(int i = 0; i < N; i++)
		    if(preSum[i] == sufSum[i]) return i + 1;
		return -1;
	}
}
//2.optimal
class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		int sum = 0;
		for(int ele : A) sum += ele;
		int leftSum = A[0];
		sum -= A[0];
		if(sum == 0) return 1;
		for(int i = 1; i < N; i++)
		{
		    sum -= A[i];
		    if(leftSum == sum) return i + 1;
		    leftSum += A[i];
		}
		return -1;
	}
}