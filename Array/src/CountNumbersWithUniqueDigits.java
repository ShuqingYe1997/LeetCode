public class CountNumbersWithUniqueDigits {
     class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if(n == 0)
                return 0;
            int[] res = new int[n];
            res[0] = 10;
            int a = 9;
            int b = 9;
            for(int i=1; i < n && b>0; i++){
                a *= b;
                res[i] = res[i-1] + a;
                b--;
            }
            return res[n-1];
        }
    }
}
