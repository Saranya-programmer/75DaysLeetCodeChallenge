import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
            int n=nums.length;
            HashMap<Integer,Integer> map1=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int more=target-nums[i];
                if(map1.containsKey(more))
                   return new int[] {map1.get(more),i};
                map1.put(nums[i],i);
            }
            return new int[]{-1,-1};
    }
        
    
}