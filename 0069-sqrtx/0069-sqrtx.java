class Solution {
    public int mySqrt(int x) {
        // int ans=1;
        // for(int i=0;i<x;i++)
        // {
        //     if(i<=x/i)
        //     {
        //       ans=i;
        //     }
        //     else{
        //     break;
        //     }
        // }
        // return ans;

        int low=1,high=x;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid<=x/mid){
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;//time limit exceeded
    }
}


