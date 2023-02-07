// imp
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        for(int i = 0; i < fruits.length; i++)
        {
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            while(map.size() > 2)
            {
                map.put(fruits[start],map.get(fruits[start]) - 1);
                if(map.get(fruits[start]) == 0)
                    map.remove(fruits[start]);
                start++;
            }
            ans = Math.max(ans,i - start + 1);
        }
        return ans;
    }
}

//optimal 
//[3 3 3 1 2 1 1 2 3 3 4]
class Solution {
    public int totalFruit(int[] fruits) {
        int lastfruit = -1;
        int second_lastfruit = -1;
        int last_fruit_count = 0;
        int curMax = 0;
        int ans = 0;
        for(int fruit : fruits)
        {
            if(fruit == lastfruit || fruit == second_lastfruit)
                curMax++;
            else
                curMax = last_fruit_count + 1;
            if(fruit == lastfruit)
                last_fruit_count++;
            else
                last_fruit_count = 1;
            if(fruit != lastfruit)
            {
                second_lastfruit = lastfruit;
                lastfruit = fruit;
            }
            ans = Math.max(ans,curMax);
        }
        return ans;
    }
}