//Amazon 9 Facebook 7 LinkedIn 6 Google 5 Microsoft 5 Apple 4 Adobe 3 Bloomberg 2 Goldman Sachs 2
//1.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] map = new boolean[nums.length];
        recurPermutation(nums,ans,map,new ArrayList<>());
        return ans;
    }
    private void recurPermutation(int []nums,List<List<Integer>> ans,boolean[] map,List<Integer> ds)
    {
        if(ds.size() == nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
       for(int i=0;i<nums.length;i++)
       {
            if(!map[i])
            {
                map[i]=true;
                ds.add(nums[i]);
                recurPermutation(nums,ans,map,ds);
                map[i]=false;
                ds.remove(ds.size()-1);
            }
       }
    }
}
//2.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        recurPermutations(0, nums, len, ans);
        return ans;
    }
    private void recurPermutations(int index, int[] nums, int len, List<List<Integer>> ans)
    {
        if(index == len)
        {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < len; i++)
                list.add(nums[i]);
            ans.add(list);
            return;
        }
        for(int i = index; i < len; i++)
        {
            swap(i, index, nums);
            recurPermutations(index + 1, nums, len, ans);
            swap(i, index, nums);
        }
    }
    private void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}