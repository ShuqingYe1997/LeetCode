/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
        Follow up:
        Coud you solve it without converting the integer to a string?

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/palindrome-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class palindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x<0)
                return false;
            else if(x<10)
                return true;

            else{
                int[] digits = new int[20];
                int cnt=0;
                int xx=x;
                while (xx!=0){
                    digits[cnt++] = xx%10;
                    xx/=10;
                }
                for(int i=0, j=cnt-1; i<=j; i++,j--){
                    if(digits[i]!=digits[j])
                        return false;
                }
                return true;
            }
        }
    }
}
