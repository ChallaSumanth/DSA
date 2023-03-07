class Solution {
    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int len = arr.length;
        for(int i = 0; i < len; i++)
        {
            List<Integer> indexes = map.getOrDefault(arr[i],new ArrayList<>());
            indexes.add(i);
            map.put(arr[i],indexes);
        }
        boolean [] visited = new boolean[len];
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);
        int level = 0;
        while(!qu.isEmpty())
        {
            int size = qu.size();
            while(size-- > 0)
            {
                Integer head = qu.poll();
                if(head == len - 1)
                    return level;
                if(head < 0 || head > arr.length - 1 || visited[head])
                    continue;
                if(head - 1 > 0 && !visited[head - 1])
                    qu.offer(head - 1);
                if(head + 1 > 0 && !visited[head + 1])
                    qu.offer(head + 1);

                if(map.containsKey(arr[head]))
                {
                    for(int index : map.get(arr[head]))
                    {
                        if(index >= 0 && index < arr.length && !visited[index])
                            qu.offer(index);
                    }
                }
                map.remove(arr[head]);
                visited[head] = true;
            }
            level++;
        }
        return -1;
    }
}