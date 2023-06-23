//https://practice.geeksforgeeks.org/problems/task-scheduler/1
class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        int[] char_map = new int[26];
        for(char c : tasks)
            char_map[c - 'A']++;
        Arrays.sort(char_map);
        int max_value = char_map[25] - 1;
        int idle_slots = max_value * K;
        for(int i = 24; i >= 0; i--)
        {
            idle_slots -= Math.min(char_map[i], max_value);
        }
        return idle_slots > 0 ? idle_slots + N : N;
    }
}
