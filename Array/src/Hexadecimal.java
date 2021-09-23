import java.util.HashMap;
import java.util.Map;

public class Hexadecimal {
    class Solution {
        public String toHex(int num) {
            char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            if(num<0)
                num&=0xffffffff;   //取低位
            StringBuffer hex = new StringBuffer();
            while (num!=0){
                int a = num%16;
                hex.append(chars[a]);
                num/=16;
            }
            return hex.toString();

        }
    }
}
