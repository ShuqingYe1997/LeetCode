public class IntegerReplacement {
    class Solution {
        public int integerReplacement(int n) {
            return recursion(n);
        }

        private int recursion (int n){
            if(n == 1)
                return 0;
            if(n == Integer.MAX_VALUE)
                return 32;
            if(n%2 == 1)
                return 1+Math.min(recursion(n+1),recursion(n-1));
            else
                return 1+recursion(n/2);
        }
    }
}
