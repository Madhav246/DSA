class Solution {

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int size = fruits.length;
        int i = 0, j = 0;
        int maxi = 1;

        while (j < size) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if (map.size() <= 2) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } else {
                while (map.size() > 2) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);

                    if (map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }

                    i++;
                }

                j++;
            }
        }

        return maxi;
    }
}
