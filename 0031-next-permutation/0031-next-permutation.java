class Solution {

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int idx = -1;

        // Find pivot
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // Swap
        if(idx != -1) {
            for(int i = n - 1; i > idx; i--) {
                if(nums[i] > nums[idx]) {

                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                    break;
                }
            }
        }

        // Reverse suffix
        reverse(nums, idx + 1, n - 1);
    }
}