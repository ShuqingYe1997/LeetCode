import java.util.Arrays;

public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int[] result = new int[digits.length+1];
            int in = 1;
            for(int i=digits.length-1;i>=0;i--){
                int sum = digits[i]+in;
                in = (sum<10? 0:1);
                result[i+1] = sum%10;
            }
            if(in==0)
                return Arrays.copyOfRange(result,1,result.length);
            else{
                result[0]=1;
                return result;
            }
        }
    }
}
