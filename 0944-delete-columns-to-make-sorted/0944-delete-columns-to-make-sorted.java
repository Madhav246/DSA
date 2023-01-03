class Solution {

    public int minDeletionSize(String[] strs) {
        if (strs.length <= 1) {
            return 0;
        }

        int row = strs.length;

        String st = strs[0];
        int col = st.length();

        char[][] matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            String s = strs[i];
            for (int j = 0; j < col; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        int count = 0;

        for (int j = 0; j < col; j++) {
            for (int i = 1; i < row; i++) {
                if (matrix[i][j] < matrix[i - 1][j]) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
