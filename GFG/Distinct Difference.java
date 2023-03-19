//https://practice.geeksforgeeks.org/problems/c670bf260ea9dce6c5910dedc165aa403f6e951d/1
class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        for(int num : A)
            right.put(num, right.getOrDefault(num, 0) + 1);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < N; i++)
        {
            right.put(A[i], right.get(A[i]) - 1);
            if(right.get(A[i]) == 0)
                right.remove(A[i]);
            ans.add(left.size() - right.size());
            left.put(A[i],left.getOrDefault(A[i] ,0)+1);
        }
        return ans;
    }
}