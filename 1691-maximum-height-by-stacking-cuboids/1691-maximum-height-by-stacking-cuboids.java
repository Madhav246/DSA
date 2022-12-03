class Solution {
    public int lis(int n, int[][] nums) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int index = 0; index < n; index++) {
            dp[index] = nums[index][2];
            
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                
                if (nums[index][0] >= nums[prevIndex][0] && nums[index][1] >= nums[prevIndex][1] && nums[index][2] >= nums[prevIndex][2]) {
                    dp[index] = Math.max(dp[index], nums[index][2] + dp[prevIndex]);
                }
            }

            maxi = Math.max(maxi, dp[index]);
        }

        return maxi;
    }

    public int maxHeight(int[][] cuboids) {
        for (int[] row : cuboids) {
            Arrays.sort(row);
        }

        Arrays.sort(cuboids, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return a[0] - b[0]; 
                    else if (a[1] != b[1]) return a[1] - b[1];
                    return a[2] - b[2];
                }
            });

        return lis(cuboids.length, cuboids);
    }
}
