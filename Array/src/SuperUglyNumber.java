import java.util.HashSet;
import java.util.Set;

// n 指针法
public class SuperUglyNumber {

    //有点慢，改进一下
    class Solution0 {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] idx = new int[primes.length];
            int[] superUglyNumbers = new int[n];
            Set<Integer> set = new HashSet();
            superUglyNumbers[0] = 1;
            for(int i=1;i<n;){
                int min = Integer.MAX_VALUE;
                int min_idx = 0;
                for(int j = 0;j<idx.length;j++){
                    if(primes[j] * superUglyNumbers[idx[j]] < min){
                        min = primes[j] * superUglyNumbers[idx[j]];
                        min_idx = j;
                    }
                }
                idx[min_idx] +=1;
                if (!set.contains(min))
                    superUglyNumbers[i++] = min;
                set.add(min);
            }
            return superUglyNumbers[n-1];
        }
    }

    //把耗时耗空间的set改成循环好多了，超越了99%的人
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] idx = new int[primes.length];
            int[] superUglyNumbers = new int[n];
            superUglyNumbers[0] = 1;
            for(int i=1;i<n;i++){
                int min = Integer.MAX_VALUE;
                int min_idx = 0;
                for(int j = 0;j<idx.length;j++){
                    if(primes[j] * superUglyNumbers[idx[j]] < min){
                        min = primes[j] * superUglyNumbers[idx[j]];
                    }
                }
                superUglyNumbers[i] = min;
                for(int j = 0;j<idx.length;j++){
                    if(primes[j] * superUglyNumbers[idx[j]] == min)
                        idx[j]++;
                }
            }
            return superUglyNumbers[n-1];
        }
    }

}
