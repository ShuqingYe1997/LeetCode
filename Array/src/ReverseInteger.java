/*
Given a 32-bit signed integer, reverse digits of an integer.
        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
        For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/reverse-integer
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class  ReverseInteger {
    class Solution {
        int MAX = (1 << 31) - 1;
        int MIN = 1 - MAX;

        public int reverse(int x) {
            StringBuffer stringBuffer = new StringBuffer();
            boolean flag = false;
            int a = 10;
            if (x < 0) {
                x = -x;
                flag = true;
            }
            while (x != 0) {
                stringBuffer.append(x % a);
                x /= a;
            }
            int ans;
            String string = stringBuffer.toString();
            if (flag)
                string = "-" + string;
            try {
                ans = Integer.parseInt(string);
            } catch (Exception e) {
                return 0;
            }
            return ans;
        }
    }
}