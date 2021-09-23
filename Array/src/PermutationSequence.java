import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    //用数学方法写,回溯超时
    // e.g. 第一个数字为1的数共有(n-1)!组
    class Solution {
        public String getPermutation(int n, int k) {
            int[] factorial = new int[n+1];
            List<Integer> digits = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            for(int i=1,a=1;i<=n;i++){
                a*=i;
                digits.add(i);
                factorial[i] = a;
            }
            k--;
            factorial[0] = 1;
            for(int i=n-1;i>=0;i--){
                int a = k/factorial[i];
                sb.append(digits.get(a));
                digits.remove(a);
                k %= factorial[i];
            }
            return sb.toString();
        }

    }
}
