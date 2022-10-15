class Solution {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int point = queue.poll();

                //If we want to move Left i..e point - arr[point];
                if (point - arr[point] >= 0) {
                    if (arr[point - arr[point]] == 0) {
                        return true;
                    } else if (arr[point - arr[point]] > 0) {
                        queue.add(point - arr[point]);
                    }
                }

                //If we want to move Right i..e point + arr[point];
                if (point + arr[point] < arr.length) {
                    if (arr[point + arr[point]] == 0) {
                        return true;
                    } else if (arr[point + arr[point]] > 0) {
                        queue.add(point + arr[point]);
                    }
                }

                arr[point] = -1;
            }
        }

        return false;
    }
}
