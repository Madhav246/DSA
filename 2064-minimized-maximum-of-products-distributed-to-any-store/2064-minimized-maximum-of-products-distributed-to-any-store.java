class Solution {

    public boolean isPossibleSolu(int[] quantities, int n, int mid) {
        int storeCount = 0;

        for (int i = 0; i < quantities.length; i++) {
            int quantity = quantities[i];

            while (quantity > 0) {
                if (quantity >= mid) {
                    quantity -= mid;
                    storeCount++;
                } else {
                    storeCount++;
                    quantity = 0;
                }
                if (storeCount > n) {
                    return false;
                }
            }
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = 0;

        for (int i = 0; i < quantities.length; i++) {
            end = Math.max(end, quantities[i]);
        }

        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (isPossibleSolu(quantities, n, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }
}
