class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int Currxor = derived[0];
        for(int i = 1; i < n; i++)
        {
            Currxor ^= derived[i];
        }
        return Currxor == 0;
    }
}