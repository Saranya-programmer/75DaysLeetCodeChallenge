class Solution {
    public int splitArray(int[] nums, int k) {
      int n=nums.length;
      int low=Integer.MIN_VALUE;
      int ans=0;
      for(int x:nums)
      {
        low=Math.max(low,x);
      }
      int high=0;
      for(int x:nums)
      {
        high=high+x;
      }
      if(k>n)
       return -1;
      while(low<=high)
      {
        int mid=(low+high)/2;
        int maxPages=mid;
        if(possible(nums,maxPages,k))
        {
            // ans=mid;
            high=mid-1;
        }
        else
        {
            low=mid+1;
        }
      }
      return low;
    }
    public boolean possible(int[] nums,int maxPages,int k)
    {
       int stu=1,sum=0;
       int n=nums.length;
       for(int i=0;i<n;i++)
       {
        if(sum+nums[i]<=maxPages)
        {
            sum=sum+nums[i];
        }
        else{
            stu++;
            sum=nums[i];
        }
       }
    return stu<=k;

    }
}