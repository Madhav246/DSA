class Solution {

    public String breakPalindrome(String palindrome) {
        char[] str = palindrome.toCharArray();
        int n = str.length;
        for (int i = 0; i < n / 2; i++) {
            if (str[i] != 'a') {
                str[i] = 'a';
                return String.valueOf(str);
            }
        }

        str[n - 1] = 'b';
        return n < 2 ? "" : String.valueOf(str);
    }
}
