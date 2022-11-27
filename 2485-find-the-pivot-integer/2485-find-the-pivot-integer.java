class Solution {

    public int pivotInteger(int n) {
        int rightSum = 0;
        for (int i = 1; i <= n; i++) {
            rightSum += i;
        }

        int leftSum = 0;

        for (int i = n; i >= 1; i--) {
            rightSum = rightSum - i;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += i;
        }

        return -1;
    }
}
