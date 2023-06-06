//Amazon 1
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int len = arr.length;
        if(len == 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 2; i < len; i++)
        {
            if(arr[i] - arr[i - 1] != diff)
                return false;
        }
        return true;
    }
}