//recursion
class Solution {
    public:
     
       long long int jump(vector<int> nums , int curr, int dest)
        {       
                if(curr>=dest) return 0; 
                long long int tmp=INT_MAX;
                
                //Try Every jump 1 to nums[curr] jump
                //and find minimum steps need to reach to end
                
                for(int i=1;i<=nums[curr];i++)
                {
                    tmp=min(tmp,1+jump(nums,curr+i,dest));  
                } 
             return tmp;  
        }
        
        int jump(vector<int>& nums) { 
             return jump(nums,0,nums.size()-1);
        }
    };
//greedy
class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int jump = 0;
        int curJump = 0;
        int len = nums.length;
        for(int i = 0; i < len - 1; i++)
        {
            farthest = Math.max(farthest,i + nums[i]);
            if(curJump == i)
            {
                jump++;
                curJump = farthest;
            }
            if(curJump > len - 1)
                return jump;
        }
        return jump;
    }
}