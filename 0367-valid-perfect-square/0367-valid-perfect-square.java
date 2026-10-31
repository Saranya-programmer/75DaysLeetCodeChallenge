class Solution {
    public boolean isPerfectSquare(int num) {
        int low=1;
        int high=num;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            long res=(long)mid*mid;
            if(res==num)
            {
                return true;
            }
            else if(res<num)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return false;
    }
}