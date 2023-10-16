class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        for(int i = 0; i < rowIndex; i++)
        {
            List<Integer> lastRow = triangle.get(triangle.size() - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int j = 1; j < lastRow.size(); j++)
                newRow.add(lastRow.get(j - 1) + lastRow.get(j));
            newRow.add(1);
            triangle.add(newRow);
        }
        return triangle.get(triangle.size() - 1);
    }
}