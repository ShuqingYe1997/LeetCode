import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    class Solution {
        public int[] numsSameConsecDiff(int N, int K) {
            if(N==0)
                return new int[0];
            List<String> res = new ArrayList<>();
            for(int i = N > 1 ? 1 : 0 ; i <= 9; i++) {
                backtrace(res, i+"", N, K);
            }
            int[] array = new int[res.size()];
            for(int i = 0;i <res.size();i++)
                array[i] = Integer.valueOf(res.get(i));
            return array;
        }

        private void backtrace(List<String> res, String temp, int n, int k) {
            if (temp.length() == n) {
                res.add(temp);
                return;
            }
            int a = temp.charAt(temp.length() - 1) - '0' + k;
            int b = temp.charAt(temp.length() - 1) - '0' - k;
            if (a <= 9)
                backtrace(res, temp + a, n, k);
            if (b >= 0 && b!=a)  // b!= a to avoid k=0
                backtrace(res, temp + b, n, k);
        }
    }
}
