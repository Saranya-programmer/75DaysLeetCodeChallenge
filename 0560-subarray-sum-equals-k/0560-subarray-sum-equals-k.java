class Solution {
    public int subarraySum(int[] nums, int k) {
      int n=nums.length;
      int prefixSum=0;
      int cnt=0;
      Map<Integer,Integer> PrefixSumMap=new HashMap<>();
      PrefixSumMap.put(0,1);
      for(int i=0;i<n;i++)
      {
          prefixSum+=nums[i];
          int rem=prefixSum-k;
          cnt+=PrefixSumMap.getOrDefault(rem,0);
          PrefixSumMap.put(prefixSum,PrefixSumMap.getOrDefault(prefixSum,0)+1);
          
      }
        return cnt;
    }
}