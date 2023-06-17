//https://practice.geeksforgeeks.org/problems/queue-operations/1

class Geeks{
    
    // Function to insert element into the queue
    
    static void insert(Queue<Integer> q, int k){
        
        // Your code here
         q.offer(k);
        
    }
    
    // Function to find frequency of an element
    // rteturn the frequency of k
    static int findFrequency(Queue<Integer> q, int k){
        
        //Your code here
        int freq = 0;
        for(Integer item : q)
        {
            if(item == k)
                freq++;
        }
        return freq;
       
    }
    
}