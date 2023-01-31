//Google
class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length())
        {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B))
            return count;
        if(sb.append(A).toString().contains(B))
            return ++count;
        return -1;
        
    }
};