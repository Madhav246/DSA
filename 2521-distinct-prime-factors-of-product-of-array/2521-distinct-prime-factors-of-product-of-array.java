class Solution {

    public HashSet<Integer> getPrime(int n) {
        HashSet<Integer> prime = new HashSet<>();

        for (int div = 2; div <= n / 2; div++) {
            while (n % div == 0) {
                n = n / div;
                prime.add(div);
            }
        }

        if (n != 1) {
            prime.add(n);
        }

        return prime;
    }

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();

        for (int number : nums) {
            HashSet<Integer> currPrime = new HashSet<>(getPrime(number));
            ans.addAll(currPrime);
        }

        return ans.size();
    }
}
