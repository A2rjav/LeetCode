class Solution {
    public int countPrimes(int n) {
        boolean primes[] = new boolean[n+1];
        Arrays.fill(primes,true);
        // primes[0] = false;
        // primes[1] = false;
        for(int i=2;i*i<n;i++){
            if(primes[i]){
                for(int j=i*i;j<n;j+=i){
                    primes[j] = false;
                }
            }
        }
        int c=0;
        for(int i=2;i<n;i++){
            if(primes[i] == true){
                c++;
            }
        }
        return c;
    }
}