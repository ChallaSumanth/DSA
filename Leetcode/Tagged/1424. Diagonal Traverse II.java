//Facebook
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        List<List<Integer>> transform = new ArrayList<>();
        int rows = nums.size();
        for(int i = 0; i < rows; i++)
        {
            int cols = nums.get(i).size();
            int x = i;
            for(int j = 0; j < cols; j++)
            {
                if(transform.size() == x)
                    transform.add(new ArrayList<>());
                transform.get(x).add(nums.get(i).get(j));
                x++;
                size++;
            }
        }
        int [] res = new int[size];
        int idx = 0;
        size = transform.size();
        for(int i = 0; i < size; i++)
        {
            for(int j = transform.get(i).size() - 1; j >= 0; j--)
            {
                res[idx] = transform.get(i).get(j);
                idx++;
            }
        }
        return res;
    }
}