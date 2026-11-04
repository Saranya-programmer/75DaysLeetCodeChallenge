class Solution {
    public int minMoves(int[] nums) {
        int maxi=nums[0];
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }
        for(int i=0;i<n;i++)
        {
            count+=maxi-nums[i];
        }
        return count;
    }
}