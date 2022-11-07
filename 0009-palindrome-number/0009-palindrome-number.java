class Solution {

    public boolean isPalindrome(int x) {
        int rev = 0;
        int n = x;

        while (x > 0) {
            int q = x % 10;

            rev = rev * 10 + q;

            x = x / 10;
        }

        if (rev == n) {
            return true;
        }
        return false;
    }
}
