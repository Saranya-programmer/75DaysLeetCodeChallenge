class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Find sum of first window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            sum += nums[i];       // add next element
            sum -= nums[i - k];   // remove first element of previous window

            maxSum = Math.max(maxSum, sum);
        }

        // Step 3: Return average
        return (double) maxSum / k;
    }
}