class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n1=nums.length;
        for(int i=0;i<n1-1;i++)
        {
            if(nums[i] == nums[i+1])
            {
                return true;
            }
        }
        return false;
    }
}