class Solution {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int index = queue.poll();

                //If we want to move Left i..e index - arr[index];
                if (index - arr[index] >= 0) {
                    if (arr[index - arr[index]] == 0) {
                        return true;
                    } else if (arr[index - arr[index]] > 0) {
                        queue.add(index - arr[index]);
                    }
                }

                //If we want to move Right i..e index + arr[index];
                if (index + arr[index] < arr.length) {
                    if (arr[index + arr[index]] == 0) {
                        return true;
                    } else if (arr[index + arr[index]] > 0) {
                        queue.add(index + arr[index]);
                    }
                }

                arr[index] = -1;
            }
        }

        return false;
    }
}
