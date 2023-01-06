class Solution {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> (Integer.compare(a[0], b[0])));

        long end = points[0][1];

        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}

