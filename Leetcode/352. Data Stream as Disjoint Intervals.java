class SummaryRanges {
    private Set<Integer> set = null;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> disJointIntervals = new ArrayList<>();

        for(int n : set)
        {
            int size = disJointIntervals.size();
            if(size > 0 && disJointIntervals.get(size-1)[1] + 1 == n)
                disJointIntervals.get(size-1)[1] = n;
            else
                disJointIntervals.add(new int[]{n,n});
        }
        return disJointIntervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */