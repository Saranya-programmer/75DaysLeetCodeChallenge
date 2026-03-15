/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n+1, 0));

        for(int num : nums)
        {
            hash.set(num, hash.get(num) + 1);
        }
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=n;i++)
        if(hash.get(i)==0)
        {
         result.add(i);
        }
        return result;
    }
}

*/

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0)
                nums[index] = -nums[index];
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            if(nums[i] > 0)
                result.add(i + 1);
        }

        return result;
    }
}