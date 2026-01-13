class Solution {
    public int largestPrime(int n) {
        int latrevison = n;

        if (n < 2) return 0; 
        
   
        boolean[] isPrime = sieve(n);


        int[] primes = new int[n];
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes[idx++] = i;
        }

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < idx; i++) {
            sum += primes[i];
            if (sum > n) break;
            if (isPrime[sum]) ans = sum;
        }
        
        return ans;
    }

    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
