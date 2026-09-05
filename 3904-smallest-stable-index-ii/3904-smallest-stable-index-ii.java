class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] suffix=new int[n];
        int mini=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            mini=Math.min(mini,nums[i]);
            suffix[i]=mini;
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(nums[i],maxi);
            int stable=maxi-suffix[i];
            if(stable<=k)
            {
                return i;
            }

        }
        return -1;

    }
}