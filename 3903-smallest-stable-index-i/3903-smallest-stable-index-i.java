class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] suffix=new int[n];
        int mn=Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--)
        {
            mn=Math.min(mn,nums[i]);
            suffix[i]=mn;

        }
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
        mx=Math.max(mx,nums[i]);
            int stable=mx-suffix[i];
            if(stable<=k)
            {
                return i;
            }
        }
        return -1;
    }

}



/*
brute force 
tc-->O(n^2)
sc-->O(1)


class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int stable=0;
        for(int i=0;i<n;i++)
        {
         int max = Arrays.stream(nums, 0, i+1)
                .max()
               .orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(nums, i, n)
                .min()
                .orElse(Integer.MAX_VALUE);
            
            stable=max-min;
            if(stable<=k)
            {
                return i;
            }
        }
        return -1;
    }

}

*/