class Solution {

    public int maxVowels(String s, int k) {
        int i = 0, j = 0;
        int size = s.length();
        int vowelCount = 0, count = 0;

        while (j < size) {
            char ch = s.charAt(j);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                count = Math.max(count, vowelCount);
                char ch1 = s.charAt(i);

                if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
                    vowelCount--;
                }

                i++;
                j++;
            }
        }

        return count;
    }
}
