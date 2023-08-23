//Amazon 17 Facebook 9 Google 4 eBay 3 Uber 2 Oracle 2
class Solution {
    public String reorganizeString(String s) {
        int len = s.length();
        if(len == 1)
            return s;
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < len; i++)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) +1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b)  - freq.get(a));
        maxHeap.addAll(freq.keySet());
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size() > 1)
        {
            char curr = maxHeap.poll();
            char next = maxHeap.poll();
            sb.append(curr);
            sb.append(next);
            int curfreq = freq.get(curr);
            int nextfreq = freq.get(next);
            freq.put(curr, curfreq - 1);
            freq.put(next, nextfreq - 1);
            if(curfreq - 1 > 0)
                maxHeap.offer(curr);
            else
                freq.remove(curr);
            if(nextfreq - 1 > 0)
                maxHeap.offer(next);
            else
                freq.remove(next);
        }
        if(!maxHeap.isEmpty())
        {
            char remaining = maxHeap.poll();
            if(freq.get(remaining) > 1)
                return "";
            sb.append(remaining);
        }
        return sb.toString();
    }
}
