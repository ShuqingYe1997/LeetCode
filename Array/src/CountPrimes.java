public class CountPrimes {
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime= new boolean[n+1];
            for(int i=0;i<isPrime.length;i++)
                isPrime[i] = true;
            int cnt = 0;
            for(int i=2;i<n;i++){
                if(isPrime[i]){
                    cnt++;
                    for(int j=2;i*j<n;j++)
                        isPrime[j] = false;
                }
            }
       return cnt;
        }

    }
}
