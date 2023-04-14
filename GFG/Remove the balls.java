.//https://practice.geeksforgeeks.org/problems/546ea68f97be7283a04ddcc8057e09b46a686471/1
class Pair
{
    int color;
    int radius;
    Pair(int color, int radius)
    {
        this.color = color;
        this.radius = radius;
    }
}
class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
        // code here
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < N; i++)
        {
            if(!st.isEmpty() && st.peek().color == color[i] && st.peek().radius == radius[i])
                st.pop();
            else
                st.push(new Pair(color[i], radius[i]));
        }
        return st.size();
    }
}
        
