class Solution{
    public int sumCounts(List<Integer> nums){
        int n=nums.size();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            
            Set<Integer> st=new HashSet<>();
            int cnt=0;
            for(int j=i;j<=n-1;j++)
            {
                st.add(nums.get(j));
                cnt=st.size();
                sum+=(cnt*cnt);
            }
            
        }
        return sum;
    }
}
