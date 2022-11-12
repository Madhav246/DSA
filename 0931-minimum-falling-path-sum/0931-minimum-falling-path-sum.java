class Solution {
//Space optimization :
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] current = new int[m];
        int[] previous = new int[n];

        for (int j = 0; j < n; j++) {
            previous[j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + previous[j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += previous[j - 1];
                } else {
                    leftDiagonal += (int) 1e9;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += previous[j + 1];
                } else {
                    rightDiagonal += (int) 1e9;
                }

                current[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }

            previous = current.clone();
        }

        int mini = previous[0];

        for (int j = 1; j < n; j++) {
            mini = Math.min(mini, previous[j]);
        }

        return mini;
    }
}
