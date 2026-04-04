class Solution {
    public List<Integer> majorityElement(int[] nums) {

    //     List<Integer> ls=new ArrayList<>();
    //     int n=nums.length;
    //     int mini=(n/3)+1;
    //     HashMap<Integer,Integer> map=new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //         if(map.get(nums[i])==mini){
    //             ls.add(nums[i]);
    //         if(ls.size()==2)
    //           break;
    //         }
    //     }
    // return ls;
    
    int n=nums.length;
    int cnt1=0,cnt2=0;
    int ele1=0,ele2=0;
    for(int i=0;i<n;i++){
        if(cnt1==0 && nums[i]!=ele2){
            cnt1=1;
            ele1=nums[i];
        }
        else if(cnt2==0 &&  nums[i]!=ele1){
            cnt2=1;
            ele2=nums[i];
        }
        else if(nums[i]==ele1)
          cnt1++;
        else if(nums[i]==ele2)
          cnt2++;
        else{
          cnt1--;
          cnt2--;
        }
    }
    int c1=0,c2=0;
    int mini=(n/3)+1;
    List<Integer> ls=new ArrayList<>();
    for(int i=0;i<n;i++){
        if(nums[i]==ele1)
          c1++;
        else if(nums[i]==ele2)
          c2++;
    }
    if(c1>=mini)
      ls.add(ele1);
    if(c2>=mini)
      ls.add(ele2);
    
    return ls;
    }
}