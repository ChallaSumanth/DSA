//Valve 1
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rqu = new LinkedList<>();
        Queue<Integer> dqu = new LinkedList<>();
        int len = senate.length();
        for(int i = 0; i < len; i++)
        {
            if(senate.charAt(i) == 'R') rqu.offer(i);
            else    dqu.offer(i);
        }
        while(!rqu.isEmpty() && !dqu.isEmpty())
        {
            int r_id = rqu.poll();
            int d_id = dqu.poll();
            if(r_id < d_id) rqu.offer(r_id + len);
            else    dqu.offer(d_id + len);
        }
        return rqu.size() > dqu.size() ? "Radiant" : "Dire";
    }
}