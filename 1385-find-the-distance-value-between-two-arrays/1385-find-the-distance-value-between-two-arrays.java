/*

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
       
       int m=arr1.length;
       int n=arr2.length;
       int cnt=0;
       boolean valid=true;
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            int diff=Math.abs(arr1[i]-arr2[j]);
            if(diff<=d)
            {
                valid=false;
                break;
            }
            else
            {
                valid=true;
            }
        }
        if(valid)
        {
            cnt+=1;
        }
       }
       return cnt;
    }
}


*/




import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int m=arr1.length;
        int n=arr2.length;
        int cnt=0;
        for(int num:arr1)
        {
            int low=0;
            int high=n;
            
            while(low<high)
            {
                int mid=low+(high-low)/2;
                if(arr2[mid]<num)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid;
                }
            }
            boolean valid=true;
            if(low<n && (long)Math.abs(arr2[low]-num)<=d)
            {
                valid=false;
            }
            if(low>0 && (long)Math.abs(arr2[low-1]-num)<=d)
            {
                valid=false;
            }
            if(valid)
            {
                cnt++;
            }
        }
        return cnt;
    }
}






