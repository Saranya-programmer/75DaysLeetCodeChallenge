class Solution {
    public int findMaxEle(int[][] mat,int m,int n,int col)
    {
        int max=-1;
        int index=-1;
        for(int i=0;i<m;i++){
        if(mat[i][col]>max){
            max=mat[i][col];
            index=i;

        }
        
    }
    return index;
    }
    public int[] findPeakGrid(int[][] mat) {
     int m=mat.length;//rows
     int n=mat[0].length;//cols
     int low=0,high=n-1;
     while(low<=high){
        int mid=(low+high)/2;
        int MaxEle=findMaxEle(mat,m,n,mid);
        int left=mid-1>=0?mat[MaxEle][mid-1]:-1;
        int right=mid+1<n?mat[MaxEle][mid+1]:-1;
        if(mat[MaxEle][mid]>left && mat[MaxEle][mid]>right)
        {
            return new int[]{MaxEle,mid};
        }
        else if(left>mat[MaxEle][mid])
        {
            high=mid-1;
        }
        else{
            low=mid+1;
        }
     }   
     return new int[]{-1,-1};
    }
}