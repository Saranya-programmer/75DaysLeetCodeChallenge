class Solution {
    public static void swapGreater(int[] nums1,int[] nums2,int i,int j){
        if(nums1[i]>nums2[j]){
            int temp=nums1[i];
            nums1[i]=nums2[j];
            nums2[j]=temp;
        }
    }
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int len=(n+m);
        int gap=(len/2)+(len%2);
        while(gap>0){
            int left=0;
            int right=left+gap;
            //nums1 and nums2
            while(right<len){
            if(left<n && right>=n)
              swapGreater(nums1,nums2,left,right-n);
            //nums2 and nums2
            else if(left>=n)
              swapGreater(nums2,nums2,left-n,right-n);
            else
              swapGreater(nums1,nums1,left,right);
            left++;
            right++;
            }
            if(gap==1) 
               break;
            gap=(gap/2)+(gap%2);
        }
        for (int i = 0; i < m; i++) {
             nums1[n + i] = nums2[i];
        }
    }
}

