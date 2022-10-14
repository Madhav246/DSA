class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n];
        
        Arrays.fill(primes, true);
        
        for(int i=2; i<n; i++){
            if(primes[i] == true){
                count++;
            }
            
            for(int j=2*i; j<n; j=j+i){
                primes[j] = false;
            }
        }
        
        return count;
    }
}