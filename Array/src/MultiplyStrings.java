import java.util.Arrays;
import java.util.Comparator;

public class MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            if(num1==null || num2==null || num1.length()==0 || num2.length()==0)
                return "";

            int[] n3 = new int[num1.length() + num2.length()];
            for(int i = num1.length()-1; i>=0; i--) {
                for (int j = num2.length()-1; j >=0; j--)
                    n3[i+j+1] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0'); //乘法的本质
            }
            int in = 0;
            for(int i = n3.length-1; i>=0 ;i--){
                n3[i]+=in;
                in = n3[i]/10;
                n3[i]%=10;
            }
            int start=0;
            for(; start<n3.length-1 && n3[start]==0;start++);

            StringBuffer sb = new StringBuffer();
            for(int i = start;i<n3.length;i++)
                sb.append(n3[i]);


            return sb.toString();
        }

    }
}
