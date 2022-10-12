class Solution {
    //Using Mod concept
    //Whenever there is something circular type we thing about mod, CLL, DQ
    int solve(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (solve(n - 1, k) + k) % n;
    }

    public int findTheWinner(int n, int k) {
        int ans = solve(n, k) + 1;
        return ans;
    }
}
