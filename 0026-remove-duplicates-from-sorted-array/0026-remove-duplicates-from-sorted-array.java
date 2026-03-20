class Solution {
    public int removeDuplicates(int[] nums)
     {
        Scanner sc=new Scanner(System.in);
        int n1=nums.length;
        int i=0;
        for(int j=i+1;j<n1;j++)
        {
            if(nums[i]!=nums[j])
            {
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}