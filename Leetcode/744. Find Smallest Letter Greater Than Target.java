//LinkedIn 4 Amazon 2 Bloomberg 2
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c : letters)
        {
            if(c > target)
                return c;
        }
        return letters[0];
    }
}
//Optimal
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        char res = letters[0];
        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(letters[mid] == target)
            {
                lo = mid + 1;
            }
            else if(letters[mid] > target)
            {
                res = letters[mid];
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        return res;
    }
}