
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ls=new ArrayList<>();
        int cnt=0;
        int cnt1=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<target)
            {
                cnt++;
            }
            else if(nums[i]==target)
            {
                cnt1++;
            }
        }
        for(int i=0;i<cnt1;i++)
        {
            ls.add(cnt+i);
        }
        return ls;
    }
}



/*

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        mergeSort(nums, 0, nums.length - 1);
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                ls.add(i);
            }

        }
        return ls;
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[low + p] = temp[p];
        }
    }
}

*/