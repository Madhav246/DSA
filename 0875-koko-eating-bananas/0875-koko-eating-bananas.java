class Solution {
    public long possibleSolu(int[] piles, long mid) {
        long time = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % mid == 0) {
                time += piles[i] / mid;
            } else {
                time += (piles[i] / mid) + 1;
            }
        }
        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long start = 1;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }

        long end = (long) maxi;
        long mid = start + (end - start) / 2;
        long ans = -1;

        while (start <= end) {
            long time = possibleSolu(piles, mid);

            if (time <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return (int) ans;
    }
}
