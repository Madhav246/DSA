class Solution {

    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        long mid = start + (end - start) / 2;
        long ans = 0;

        while (start <= end) {
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            }

            if (square < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return (int) ans;
    }
}
