class Solution {

    public int solve(int[] arr, int index) {
        int prev1 = arr[0];
        int prev2 = 0;

        for (int i = 1; i < index; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick += prev2;
            }
            int notPick = 0 + prev1;

            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1){
            return nums[0];
        }
        
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        int j = 0;
        

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1[j++] = nums[i];
            }
            if (i != n - 1) {
                temp2[i] = nums[i];
            }
        }

        int ans = Math.max(solve(temp1, n - 1), solve(temp2, n - 1));
        return ans;
    }
}
