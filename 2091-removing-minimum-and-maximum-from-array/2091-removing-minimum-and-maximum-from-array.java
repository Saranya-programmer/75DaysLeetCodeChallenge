class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int index=-1;
        int index1=-1;
        if(n==1)
        {
            return 1;
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
                index=i;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index1=i;
            }
        }
        
        //finding earlier and later ones
        int a=Math.min(index,index1);
        int b=Math.max(index,index1);

        //case1---> both from front

        int case1=b+1;

        //case2---> both from back
        int case2=n-a;

        //case3----> Earlier from front, later from back
        int case3=(a+1)+(n-b);

        //case4----> Earlier from back, later from front
        int case4=(n-a)+(b+1);


      return Math.min(
        Math.min(case1,case2),
        Math.min(case3,case4)
      );
  
    }
}