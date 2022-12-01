class Solution {

    public boolean checkPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        if (first == s1.length() && second == s2.length()) return true;
        return false;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = -1;
        
        Arrays.sort(words,(a,b)->a.length() - b.length());

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (checkPossible(words[index], words[prevIndex]) && 1 + dp[prevIndex] > dp[index]) {
                    dp[index] = 1 + dp[prevIndex];
                }
            }

            if (dp[index] > maxi) {
                maxi = dp[index];
            }
        }

        return maxi;
    }
}
