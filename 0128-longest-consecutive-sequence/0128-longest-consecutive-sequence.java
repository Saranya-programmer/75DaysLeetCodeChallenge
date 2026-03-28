class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int longest=1;
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int x=num;
                int cnt=1;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;

    }
}