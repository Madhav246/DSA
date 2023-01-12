class Solution {

    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            char ch3 = s.charAt(i + 2);

            if (ch1 != ch2 && ch2 != ch3 && ch3 != ch1) {
                count++;
            }
        }

        return count;
    }
}
