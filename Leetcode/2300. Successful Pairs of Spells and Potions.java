class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [] spells0 = spells.clone();
        Arrays.sort(spells);
        Arrays.sort(potions);
        Map<Integer, Integer> map = new HashMap<>();
        int n = spells.length;
        int m = potions.length;
        int j = m - 1;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
        {
            while(j >= 0 && 1L * spells[i] * potions[j] >= success)
                j--;
            map.put(spells[i], m - j - 1);
        }
        for(int i = 0; i < n; i++)
            ans[i] = map.get(spells0[i]);
        return ans;
    }
}